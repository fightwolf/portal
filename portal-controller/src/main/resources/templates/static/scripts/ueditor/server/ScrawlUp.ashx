<%@ WebHandler Language="C#" Class="ScrawlImgUp" %>

using System;
using System.Web;
using System.IO;
using System.Collections;

public class ScrawlImgUp : IHttpHandler
{

    public void ProcessRequest(HttpContext context)
    {
        context.Response.ContentType = "text/html";
        string action = context.Request["action"];
        if (context.Request.Files != null && context.Request.Files.Count > 0)
        {
            var file = context.Request.Files[0];
            var fileName = file.FileName;
            var uploadFile = FileUpload.Client.UploadFile.Parse(file);
            var result = FileUpload.Client.DFSService.Upload("pohto", uploadFile);
            if (result.Status == 0)
            {
                context.Response.Write("<script>parent.ue_callback('" + result.Items[0] + "','SUCCESS')</script>");
            }
            else
            {
                context.Response.Write("<script>parent.ue_callback('','" + result.Message + "')</script>");
            }
        }
        else
        {
            context.Response.Write("<script>parent.ue_callback('','请选择上传文件')</script>");
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