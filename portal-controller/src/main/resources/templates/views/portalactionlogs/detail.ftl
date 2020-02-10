<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>wolf</title><#include '../tags/header.ftl'/></head>
<body class="page-header-fixed"><!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse navbar-fixed-top">    <!-- BEGIN TOP NAVIGATION BAR -->
    <#include '../tags/top.ftl'/>    <!-- END TOP NAVIGATION BAR --></div><!-- END HEADER -->
<div id="bodyContaner">
    <div class="container-fluid">
        <div class="row-fluid" style="margin-top:25px;">
            <div class="span12"><h3 class="page-title"></h3>
                <ul class="breadcrumb">
                    <li><i class="icon-home"></i> <a href="/dashboard">首页</a> <i class="icon-angle-right"></i></li>
                    <li><a href="/portalactionlogs/list">列表</a> <i class="icon-angle-right"></i></li>
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
                                        <label class="control-label" for="typeahead">类型id： </label>
                                        <div class="controls">
                                            <input id="txtoperation_type" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.operationType!}</#if>"
                                                   data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">类型： </label>
                                        <div class="controls">
                                            <input id="txtoperation_name" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.operationName!}</#if>"
                                                   data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">父级code： </label>
                                        <div class="controls">
                                            <input id="txtparent_code" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.parentCode!}</#if>"
                                                   data-provide="typeahead"
                                                   data-items="4"/>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">describes： </label>
                                        <div class="controls">
                                            <textarea id="txtdescribes"
                                                      class="span6  medium "><#if item??>${item.describes!}</#if></textarea>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">ip： </label>
                                        <div class="controls">
                                            <input id="txtip" type="text" class="m-wrap medium typeahead"
                                                   value="<#if item??>${item.ip!}</#if>" data-provide="typeahead"
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
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">create_timestamp： </label>
                                        <div class="controls">
                                            <input id="txtcreate_timestamp" class="span4  medium "
                                                   value="<#if item??>${item.createTimestamp?string('yyyy-MM-dd hh:mm:ss')}</#if>"></input>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="typeahead">last_update_timestamp： </label>
                                        <div class="controls">
                                            <input id="txtlast_update_timestamp" class="span4  medium "
                                                   value="<#if item??>${item.lastUpdateTimestamp?string('yyyy-MM-dd hh:mm:ss')}</#if>"></input>
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
    $("#txtcreate_timestamp").datetimepicker({format: 'Y-m-d', timepicker: false});
    $("#txtlast_update_timestamp").datetimepicker({format: 'Y-m-d', timepicker: false});
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
        data.operation_type = $("#txtoperation_type").val();
        data.operation_name = $("#txtoperation_name").val();
        data.parent_code = $("#txtparent_code").val();
        data.describes = $("#txtdescribes").val();
        data.ip = $("#txtip").val();
        data.creator_id = $("#txtcreator_id").val();
        data.creator_name = $("#txtcreator_name").val();
        data.create_timestamp = $("#txtcreate_timestamp").val();
        data.last_update_timestamp = $("#txtlast_update_timestamp").val();
        $.post("/PortalActionLogs/save", {datas: JSON.stringify(data)}, function (data) {
            if (data.code === 0) {
                alert('操作成功!');
                window.location.href = '/portalactionlogs/list';
            } else {
                alert('操作失败!' + data.message);
            }
        });
    });
});</script>
</body>
</html>