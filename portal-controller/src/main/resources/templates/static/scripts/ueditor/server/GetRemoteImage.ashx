<%@ WebHandler Language="C#" Class="GetRemoteImage" %>

using System;
using System.Web;
using System.Collections;
using System.Text.RegularExpressions;
using System.Net;
using System.IO;

public class GetRemoteImage : IHttpHandler
{

    public void ProcessRequest(HttpContext context)
    {
        string[] filetype = { ".gif", ".png", ".jpg", ".jpeg", ".bmp" };             //文件允许格式
        int fileSize = 20*1024;                                                        //文件大小限制，单位kb
        string uri = context.Server.HtmlEncode(context.Request["upfile"]);
        uri = uri.Replace("&amp;", "&");
        string[] imgUrls = Regex.Split(uri, "ue_separate_ue", RegexOptions.IgnoreCase);
        ArrayList tmpNames = new ArrayList();
        WebClient wc = new WebClient();
        HttpWebResponse res;
        String tmpName = String.Empty;
        String imgUrl = String.Empty;
        String currentType = String.Empty;
        try
        {
            for (int i = 0, len = imgUrls.Length; i < len; i++)
            {
                imgUrl = imgUrls[i];

                if (imgUrl.Substring(0, 7) != "http://")
                {
                    tmpNames.Add("error!");
                    continue;
                }

                //格式验证
                int temp = imgUrl.LastIndexOf('.');
                currentType = imgUrl.Substring(temp).ToLower();
                if (Array.IndexOf(filetype, currentType) == -1)
                {
                    tmpNames.Add("error!");
                    continue;
                }

                res = (HttpWebResponse)WebRequest.Create(imgUrl).GetResponse();
                //http检测
                if (res.ResponseUri.Scheme.ToLower().Trim() != "http")
                {
                    tmpNames.Add("error!");
                    continue;
                }
                //大小验证
                if (res.ContentLength > fileSize * 1024)
                {
                    tmpNames.Add("error!");
                    continue;
                }
                //死链验证
                if (res.StatusCode != HttpStatusCode.OK)
                {
                    tmpNames.Add("error!");
                    continue;
                }
                //检查mime类型
                if (res.ContentType.IndexOf("image") == -1)
                {
                    tmpNames.Add("error!");
                    continue;
                }
                res.Close();

                var buffer=wc.DownloadData(imgUrl);
                var fileName=imgUrl.Substring(imgUrl.LastIndexOf("/")+1);
                var result = FileUpload.Client.DFSService.Upload("pohto", new FileUpload.Client.UploadFile { ContentType = currentType, FilenName = fileName, FileBuffer = buffer });
                
                if (result.Status == 0)
                {
                    tmpNames.Add(result.Items[0]);
                }
            }
        }
        catch (Exception)
        {
            tmpNames.Add("error!");
        }
        finally
        {
            wc.Dispose();
        }
        context.Response.Write("{url:'" + ConverToString(tmpNames) + "',tip:'远程图片抓取成功！',srcUrl:'" + uri + "'}");
    }

    //集合转换字符串
    private string ConverToString(ArrayList tmpNames)
    {
        String str = String.Empty;
        for (int i = 0, len = tmpNames.Count; i < len; i++)
        {
            str += tmpNames[i] + "ue_separate_ue";
            if (i == tmpNames.Count - 1)
                str += tmpNames[i];
        }
        return str;
    }

    public bool IsReusable
    {
        get
        {
            return false;
        }
    }

}