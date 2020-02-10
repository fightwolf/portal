<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>wolf</title><#include '../tags/header.ftl'/></head>
<body class="page-header-fixed"><!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse navbar-fixed-top">    <!-- BEGIN TOP NAVIGATION BAR -->
    <#include '../tags/top.ftl'/>  <!-- END TOP NAVIGATION BAR --></div><!-- END HEADER -->
<div id="bodyContaner">
    <div class="container-fluid">
        <div class="row-fluid" style="margin-top:25px;">
            <div class="span12"><h3 class="page-title"></h3>
                <ul class="breadcrumb">
                    <li><i class="icon-home"></i> <a href="/dashboard">首页</a> <i class="icon-angle-right"></i></li>
                    <li><a href="/portalusers/list">列表</a> <i class="icon-angle-right"></i></li>
                    <li><a href="#">详情</a></li>
                </ul>
            </div>
            <h3 class="page-title"></h3></div>
        <div class="row-fluid">
            <div class="span12">
                <div class="portlet box grey">
                    <div class="portlet-title">
                        <div class="caption"><i class="icon-cogs"></i>详情</div>
                        <div class="tools"><a href="javascript:;" class="collapse"></a> <a href="#portlet-config"
                                                                                           data-toggle="modal"
                                                                                           class="config"></a> <a
                                href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a></div>
                    </div>
                    <div class="portlet-body table-responsive">
                        <div class="row-fluid sortable ui-sortable">
                            <div class="box-content">
                                <div class="form-horizontal">
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">Id： </label>
                                        <div class="controls">
                                            <input id="txtId" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.id!}</#if>" data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">Code： </label>
                                        <div class="controls">
                                            <input id="txtuser_code" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.userCode!}</#if>" data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">名称： </label>
                                        <div class="controls">
                                            <input id="txtuser_name" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.userName!}</#if>" data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">密码： </label>
                                        <div class="controls">
                                            <input id="txtuser_pwd" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.userPwd!}</#if>" data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">类型： </label>
                                        <div class="controls">
                                            <select id="selCategory" class="m-wrap medium">
                                                <option value="0">请选择</option>
                                            </select></div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">Email： </label>
                                        <div class="controls">
                                            <input id="txtuser_email" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.userEmail!}</#if>" data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">Phone： </label>
                                        <div class="controls">
                                            <input id="txtuser_phone" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.userPhone!}</#if>" data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">头像： </label>
                                        <div class="controls">
                                            <button type="button" id="btnUpLogo" class="btn  green"><i
                                                    class="icon-ok"></i>上传avatar
                                            </button>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead"> </label>
                                        <div class="controls">
                                            <img src="<#if item??>${item.avatar!}</#if>" id="imgavatar"
                                                 style="height:120px;"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">注册ip： </label>
                                        <div class="controls">
                                            <input id="txtregiste_ip" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.registeIp!}</#if>" data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">创建人id： </label>
                                        <div class="controls">
                                            <input id="txtcreator_id" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.creatorId!}</#if>" data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">创建人： </label>
                                        <div class="controls">
                                            <input id="txtcreator_name" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.creatorName!}</#if>"
                                                   data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>

                                    <div class="control-group"><label class="control-label" for="typeahead"></label>
                                        <div class="controls">
                                            <button type="button" id="btnSave" class="btn blue"><i class="icon-ok"></i>提交
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="none">
        <form id="frmAttachment" action="/file/upload" enctype="multipart/form-data" method="post" name="frmAttachment"
              target="uploadTarget"><input type="file" style="position: absolute; left: -999em; top: -999em;"
                                           id="attachFile" name="attachFile"/>
            <iframe id="uploadTarget" name="uploadTarget"
                    style="position: absolute; left: -999em; top: -999em;"></iframe>
        </form>
    </div>
</div><#include '../tags/footer.ftl'/>
<script src="../static/scripts/ueditor/ueditor.config.js"></script>
<script src="../static/scripts/ueditor/ueditor.all.min.js"></script>
<link type="text/css" href="../static/content/jquery.datetimepicker.css" rel="stylesheet"/>
<script src="../static/scripts/jquery.datetimepicker.js"></script>
<script type="text/javascript">    var uploadAttachment = {
    position: 0, attachments: [], checkImageURL: function () {
        return (url.match(/\.(jpeg|jpg|gif|png|bmp)$/i) != null);
    }, up: function () {
        if ($("#attachFile").val().length < 4) {
            alert('请选择上传文件!');
            return;
        }
        $frmAttachment = $("#frmAttachment");
        $frmAttachment.submit();
    }, complete: function () {
        document.getElementById("frmAttachment").reset();
        var result = $.parseJSON($("#uploadTarget").contents().find("pre").first().text());
        if (uploadAttachment.position == 0) {
            $("#imgLogo").attr("src", result.Url);
        } else {
            $("#imgIcon").attr("src", result.Url);
        }
    }, init: function () {
        $("#uploadTarget").on("load", function () {
            uploadAttachment.complete();
        });
        var $input = $('#attachFile');
        var ie = !-[1,];
        if (ie) {
            $input.click(function (event) {
                setTimeout(function () {
                    uploadAttachment.up();
                }, 0);
            });
        } else {
            $input.change(uploadAttachment.up);
        }
    }
};
$(document).ready(function () {
    uploadAttachment.init();
    $("#btnUpLogo").click(function () {
        uploadAttachment.position = 0;
        $("#attachFile").click();
    });
    $("#btnIcon").click(function () {
        uploadAttachment.position = 1;
        $("#attachFile").click();
    });
    $("#btnSave").click(function () {
        var data = {};
        data.Id = $("#txtId").val();
        data.user_code = $("#txtuser_code").val();
        data.user_name = $("#txtuser_name").val();
        data.user_pwd = $("#txtuser_pwd").val();
        data.user_type = $("#selCategory").find("option:selected").val();
        data.user_email = $("#txtuser_email").val();
        data.user_phone = $("#txtuser_phone").val();
        data.avatar = $("#imgavatar").attr("src");
        data.registe_ip = $("#txtregiste_ip").val();
        data.creator_id = $("#txtcreator_id").val();
        data.creator_name = $("#txtcreator_name").val();
        $.post("/PortalUsers/save", {datas: JSON.stringify(data)}, function (data) {
            if (data.code === 0) {
                alert('操作成功!');
                window.location.href = '/portalusers/list';
            } else {
                alert('操作失败!' + data.message);
            }
        });
    });
});</script>
</body>
</html>