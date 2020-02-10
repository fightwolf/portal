<%@ WebHandler Language="C#" Class="FileUp" %>

using System;
using System.Web;
using System.IO;
using System.Collections;

public class FileUp : IHttpHandler
{

    public void ProcessRequest(HttpContext context)
    {
        context.Response.ContentType = "text/plain";
        if (context.Request.Files != null && context.Request.Files.Count > 0)
        {
            var file = context.Request.Files[0];
            var fileName = file.FileName;
            var uploadFile = FileUpload.Client.UploadFile.Parse(file);
            var result = FileUpload.Client.DFSService.Upload("NoticeFile", uploadFile);
            if (result.Status == 0)
            {
                context.Response.Write("{'state':'SUCCESS','url':'" + result.Items[0] + "','fileType':'" + GetFileExt(fileName) + "','original':'" + fileName + "'}");
            }
            else
            {
                context.Response.Write("{'state':'" + result.Message + "','url':'','fileType':'','original':''}");
            }
        }
        else
        {
            context.Response.Write("{'state':'请选择上传文件','url':'','fileType':'','original':''}");
        }
    }

    private string GetFileExt(string filename)
    {
        string[] temp = filename.Split('.');
        return "." + temp[temp.Length - 1].ToLower();
    }

    public bool IsReusable
    {
        get
        {
            return false;
        }
    }

}