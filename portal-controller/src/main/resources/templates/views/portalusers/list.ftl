<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>wolf</title><#include '../tags/header.ftl'/></head>
<body class="page-header-fixed"><!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse navbar-fixed-top">
    <!-- BEGIN TOP NAVIGATION BAR -->
   <#include '../tags/top.ftl'/>
    <!-- END TOP NAVIGATION BAR --></div><!-- END HEADER -->
<div class="page-container"><#include '../tags/left.ftl' />
    <div class="page-content">
        <div class="container-fluid">            <!-- BEGIN PAGE HEADER-->
            <div class="row-fluid">
                <div class="span12">                    <!-- BEGIN STYLE CUSTOMIZER -->
                    <div class="color-panel hidden-phone">
                        <div class="color-mode-icons icon-color"></div>
                        <div class="color-mode-icons icon-color-close"></div>
                        <div class="color-mode"><p>THEME COLOR</p>
                            <ul class="inline">
                                <li class="color-black current color-default" data-style="default"></li>
                                <li class="color-blue" data-style="blue"></li>
                                <li class="color-brown" data-style="brown"></li>
                                <li class="color-purple" data-style="purple"></li>
                                <li class="color-grey" data-style="grey"></li>
                                <li class="color-white color-light" data-style="light"></li>
                            </ul>
                            <label> <span>Layout</span> <select class="layout-option m-wrap small">
                                <option value="fluid" selected>Fluid</option>
                                <option value="boxed">Boxed</option>
                            </select> </label> <label> <span>Header</span> <select class="header-option m-wrap small">
                                <option value="fixed" selected>Fixed</option>
                                <option value="default">Default</option>
                            </select> </label> <label> <span>Sidebar</span> <select class="sidebar-option m-wrap small">
                                <option value="fixed">Fixed</option>
                                <option value="default" selected>Default</option>
                            </select> </label> <label> <span>Footer</span> <select class="footer-option m-wrap small">
                                <option value="fixed">Fixed</option>
                                <option value="default" selected>Default</option>
                            </select> </label></div>
                    </div>                    <!-- END BEGIN STYLE CUSTOMIZER -->
                    <h3 class="page-title"> portal
                        <small>产品中心</small>
                    </h3>
                </div>
            </div>            <!-- END PAGE HEADER-->        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12"><h3 class="page-title"></h3>
                    <ul class="breadcrumb">
                        <li><i class="icon-home"></i> <a href="/dashboard">首页</a> <i class="icon-angle-right"></i></li>
                        <li><a href="/portalusers/list">列表</a> <i class="icon-angle-right"></i></li>
                    </ul>
                </div>
            </div>
            <div class="row-fluid">
                <div class="span12">
                    <div class="portlet box grey">
                        <div class="portlet-title">
                            <div class="caption"><i class="icon-cogs"></i>列表</div>
                            <div class="tools"><a href="javascript:;" class="collapse"></a> <a id="btnAdd"
                                                                                               href="/portalusers/detail"
                                                                                               class="icon-plus"></a> <a
                                    href="javascript:;" class="reload"></a> <a href="javascript:;" class="remove"></a>
                            </div>
                        </div>
                        <div class="portlet-body table-responsive">
                            <div class="form-inline"><input type="text" id="txtKeyword"
                                                            class="m-wrap medium">&nbsp;<input id="btnSearch"
                                                                                               class="btn blue"
                                                                                               type="button"
                                                                                               value="确定"/></div>
                            <table class="table table-striped" id="gvResult"></table>
                            <div id="Pager"></div>
                        </div>
                    </div>
                </div>
            </div>            <!--/span-->        </div>
    </div>
</div><#include '../tags/footer.ftl'/>
<script type="text/js-render" id="portalusersTemplate">        <tr>
            <td>{{:id}}</td>
            <td>{{:userCode}}</td>
            <td>{{:userName}}</td>
            <td>{{:userType}}</td>
            <td>{{:userEmail}}</td>
            <td>{{:userPhone}}</td>
<td><img src="{{:avatar}}" alt="" style="height:50px;" class="plus-cursor" data-image="{{:avatar}}" data-title="" data-caption="" /></td>
            <td>{{:registeIp}}</td>
            <td>{{:creatorName}}</td>
            <td>{{:createTimestamp}}</td>
 <td> <span class="label label-info"><a href="/portalusers/detail?id={{:id}}" onclick="">编辑</a></span> </td></tr>
</script>
<script type="text/javascript">    var portalusersObject = {
    option: {
        pageIndex: 1,
        pageSize: 15,
        pageCount: 0,
        count: 0,
        loading: '<tr><td colspan="6"><div><img src="../static/content/images/loading.gif" alt="Loading" /></div></td></tr>',
        listHeader: '<thead>' +
        '<tr role="row">' +
        '<th >Id</th>' +
        '<th >Code</th>' +
        '<th >名称</th>' +
        '<th >类型</th>' +
        '<th >Email</th>' +
        '<th >Phone</th>' +
        '<th >头像</th>' +
        '<th >注册ip</th>' +
        '<th >创建人</th>' +
        '<th >创建时间</th>' +
        '<th>操作</th>' +
        '</tr>' +
        '</thead>'
    }, bindMethod: function () {
        $("#btnSearch").click(function () {
            portalusersObject.option.pageIndex = 1;
            portalusersObject.loadData();
        });
    }, remove: function (id) {
        if (confirm('确认 改变角色状态吗？')) {
            $.post("/PortalUsers/changeStatues", {id: id}, function (data) {
                if (data.Code == 0) {
                    portalusersObject.loadData();
                } else {
                    alert('操作失败!');
                }
            });
        }
    }, changeAr: function (id, obj) {
        $.post("/PortalUsers/changeAr", {id: id, ar: obj}, function (data) {
            if (data.Code == 0) {
                portalusersObject.loadData();
            }
        });
    }, loadData: function () {
        var keyword = $("#txtKeyword").val();
        $("#gvResult").html(portalusersObject.option.loading);
        $.getJSON("/PortalUsers/getPageList", {
            pageIndex: portalusersObject.option.pageIndex,
            pageSize: portalusersObject.option.pageSize,
            key: ""
        }, function (data) {
            var obj = data.data, content = [];
            $("#gvResult").html(portalusersObject.option.listHeader);
            portalusersObject.option.count = obj.count;
            for (var i = 0; i < obj.items.length; i++) {
                obj.items[i].lastUpdateTimestamp=moment(obj.items[i].lastUpdateTimestamp).format("YYYY-MM-DD HH:mm:ss");
            }
            $("#gvResult").append($("#portalusersTemplate").render(obj.items));
            $.each($('.isAr'), function () {
                new Medium({
                    element: document.getElementById(this.id),
                    mode: Medium.inlineMode,
                    maxLength: 25,
                    placeholder: '...'
                });
            });
            $('.isAr').on('blur', function () {
                portalusersObject.changeAr($(this).attr('data-id'), $(this).html());
            });
            App.handleUniform();
            <!--pager-->
            var pager = new pagination.init('Pager');
            pager.itemCount = portalusersObject.option.count;
            pager.size = portalusersObject.option.pageSize;
            pager.index = portalusersObject.option.pageIndex;
            pager.onclick = function (indexs) {
                portalusersObject.option.pageIndex = indexs;
                portalusersObject.loadData();
            };
            pager.render();
            var elements = document.querySelectorAll('.plus-cursor');
            Intense(elements);
        });
    }
};
$(function () {
    portalusersObject.loadData();
});</script>
</body>
</html>