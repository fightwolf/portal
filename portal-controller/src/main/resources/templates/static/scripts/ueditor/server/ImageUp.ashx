<%@ WebHandler Language="C#" Class="ImageUp" %>

using System;
using System.Web;
using System.IO;
using System.Collections;

public class ImageUp : IHttpHandler
{
    public void ProcessRequest(HttpContext context)
    {
        context.Response.ContentType = "text/plain";
        if (context.Request.Files != null && context.Request.Files.Count > 0)
        {
            var file = context.Request.Files[0];
            var fileName = file.FileName;

            var f = FileUpload.Client.UploadFile.Parse(file);
            var result = FileUpload.Client.DFSService.Upload("NoticePhoto", f);

            if (result.Status == 0)
            {
                context.Response.Write("{'url':'" + result.Items[0] + "','title':'" + fileName + "','original':'" + fileName + "','state':'SUCCESS'}");
            }
            else
            {
                context.Response.Write("{'url':'','title':'','original':'','state':'" + result.Message + "'}");
            }
        }
        else
        {
            context.Response.Write("{'url':'','title':'','original':'','state':'请选择上传文件'}");
        }
    }

    public bool IsReusable
    {
        get
        {
            return false;
        }
    }

}