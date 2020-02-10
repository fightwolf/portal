<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>wolf</title>
<#include 'tags/header.ftl'/>
</head>

<body class="page-header-fixed">
<#--@Html.Partial("_Header")-->
<!-- BEGIN HEADER -->

<div class="header navbar navbar-inverse navbar-fixed-top">

    <!-- BEGIN TOP NAVIGATION BAR -->



<#include 'tags/top.ftl'/>

    <!-- END TOP NAVIGATION BAR -->
</div>

<!-- END HEADER -->
<div class="page-container" style="min-height: 700px;">


    <h1 style="margin-top: 100px;margin-left: 200px;">Comming soon!</h1>


</div>

<#include 'tags/footer.ftl'/>

<script type="text/js-render" id="roleTemplate">
        <tr>
             <td>{{:id}}</td>
            <td>{{:category}}</td>

             <td>{{:homeicon}}</td>
             <td>{{:homename}}</td>

             <td>{{:homecount}}</td>

            <td>{{:opponenticon }}</td>
            <td>{{:opponentname}}</td>

            <td>{{:opponentscount}}</td>
        </tr>




</script>
<script type="text/javascript">


    var applicationObject = {
                option: {
                    pageIndex: 1,
                    pageSize: 20,
                    pageCount: 0,
                    count: 0,
                    loading: '<tr><td colspan="6"><div><img src="../static/content/images/loading.gif" alt="Loading" /></div></td></tr>',
                    listHeader: '<thead>' +
                    '<tr role="row">' +
                    '<th >ID</th>' +
                    '<th >分类</th>' +


                    '<th >主场ICON</th>' +
                    '<th >主场</th>' +

                    '<th >主场比分</th>' +


                    '<th >客场ICON</th>' +
                    '<th >客场</th>' +

                    '<th >客场比分</th>' +

                    '</tr>' +
                    '</thead><tbody id="gvBody"></tbody>',
                },
                showCategory: function (cid) {
                    return $("#selCategory").find("option[value=" + cid + "]").text();
                },
                changeItem: function (id, type, value) {
                    $.post("/api/activity/changeItem", {id: id, type: type, data: value}, function (data) {

                        //  alert(JSON.parse(data).message);

                    });
                },

                loadData: function () {
                    var keyword = $("#txtKeyword").val();
                    applicationObject.option.pageSize = $('#selPageSize').val();
                    $("#gvResult").html(applicationObject.option.loading);
                    $.getJSON("/api/activity/list", {}, function (data) {
                        var obj = data, content = [];
                        $("#gvResult").html(applicationObject.option.listHeader);

                        for (var i = 0; i < obj.data.length; i++) {


                            obj.data[i].ar = '<text type="input" class="isAr" data-id="' + obj.data[i].id + '" id="ar' + obj.data[i].id + '">' + obj.data[i].ar + '</text>';
                            obj.data[i].category = '<text type="input"  class="isCate" data-id="' + obj.data[i].id + '" id="cate' + obj.data[i].id + '">' + obj.data[i].category + '</text>';

                            obj.data[i].homecount = '<text type="input"  class="isHomeCount" data-id="' + obj.data[i].id + '" id="homecount' + obj.data[i].id + '">' + obj.data[i].homecount + '</text>';
                            obj.data[i].homeenname = '<text type="input"  class="isHomeEnName" data-id="' + obj.data[i].id + '" id="homeenname' + obj.data[i].id + '">' + obj.data[i].homeenname + '</text>';
                            obj.data[i].homeicon = '<span type="input"  class="isHomeIncon" data-id="' + obj.data[i].id + '" id="homicon' + obj.data[i].id + '">' + obj.data[i].homeicon + '</span>';
                            obj.data[i].homename = '<text type="input"  class="isHomeName" data-id="' + obj.data[i].id + '" id="homename' + obj.data[i].id + '">' + obj.data[i].homename + '</text>';

                            obj.data[i].opponentenname = '<text type="input"  class="IsOpEnName" data-id="' + obj.data[i].id + '" id="openname' + obj.data[i].id + '">' + obj.data[i].opponentenname + '</text>';
                            obj.data[i].opponenticon = '<span type="input"  class="IsOpIcon" data-id="' + obj.data[i].id + '" id="opicon' + obj.data[i].id + '">' + obj.data[i].opponenticon + '</span>';
                            obj.data[i].opponentname = '<text type="input"  class="IsOpName" data-id="' + obj.data[i].id + '" id="opname' + obj.data[i].id + '">' + obj.data[i].opponentname + '</text>';
                            obj.data[i].opponentscount = '<text type="input"  class="IsOpCount" data-id="' + obj.data[i].id + '" id="opcount' + obj.data[i].id + '">' + obj.data[i].opponentscount + '</text>';
                        }
                        $("#gvBody").append($("#roleTemplate").render(obj.data));

                        $.each($('.isAr,.isCate,.isHomeCount,.isHomeEnName,.isHomeName,.IsOpEnName,.IsOpName,.IsOpCount,.isHomeIncon,.IsOpIcon'), function () {
                            new Medium({
                                element: document.getElementById(this.id),
                                mode: Medium.inlineMode,
                                maxLength: 25,
                                placeholder: '...'
                            });
                        });
                        $('.isAr').on('blur', function () {
                            applicationObject.changeItem($(this).attr('data-id'), 1, $(this).html());
                        });
                        $('.isCate').on('blur', function () {
                            applicationObject.changeItem($(this).attr('data-id'), 2, $(this).html());
                        });

                        $('.isHomeCount').on('blur', function () {
                            applicationObject.changeItem($(this).attr('data-id'), 3, $(this).html());
                        });
                        $('.isHomeEnName').on('blur', function () {
                            applicationObject.changeItem($(this).attr('data-id'), 4, $(this).html());
                        });
                        $('.isHomeName').on('blur', function () {
                            applicationObject.changeItem($(this).attr('data-id'), 5, $(this).html());
                        });


                        $('.IsOpCount').on('blur', function () {
                            applicationObject.changeItem($(this).attr('data-id'), 6, $(this).html());
                        });
                        $('.IsOpEnName').on('blur', function () {
                            applicationObject.changeItem($(this).attr('data-id'), 7, $(this).html());
                        });
                        $('.IsOpName').on('blur', function () {
                            applicationObject.changeItem($(this).attr('data-id'), 8, $(this).html());
                        });


                        $('.isHomeIncon').on('blur', function () {
                            applicationObject.changeItem($(this).attr('data-id'), 9, $(this).html());
                        });
                        $('.IsOpIcon').on('blur', function () {
                            applicationObject.changeItem($(this).attr('data-id'), 10, $(this).html());
                        });


//                $('.isHomeIncon,.IsOpIcon').on('click', function () {
//                    alert('弹出框');
//                });


                        App.handleUniform();

                    });
                }
            }
    ;

    $(function () {

        $("#btnEnd").click(function () {
            var time = $("#txtTime").val();
            if (time.length > 5)
                $.post("/api/activity/changeRacetime", {time: time}, function (data) {
                    var obj = $.parseJSON(data);
                    if (obj.code == 0) {
                        alert('操作完成');
                    } else {
                        alert('操作失败' + data.message);
                    }

                });
        });
        applicationObject.loadData();

    });
</script>
</body>
</html>