<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>wolf</title>
    <!-- Fav and touch icons -->

    <link rel="shortcut icon" href="../static/content/images/icons/logo-32x32.ico">

    <link href="../static/content/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <link href="../static/content/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

    <link href="../static/content/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

    <link href="../static/content/media/css/style-metro.css" rel="stylesheet" type="text/css"/>

    <link href="../static/content/media/css/style.css?t=20180417" rel="stylesheet" type="text/css"/>

    <link href="../static/content/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

    <link href="../static/content/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

    <link href="../static/content/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->

    <link href="../static/content/media/css/login.css" rel="stylesheet" type="text/css"/>
</head>

<body class="login" style="overflow-x:hidden !important;">

<!-- BEGIN LOGO -->

<div class="logo">

<#--<img alt="" src="../static/content/media/image/logo.png" style="height:60px;">-->
</div>

<!-- END LOGO -->
<!-- BEGIN LOGIN -->
<div class="content">

    <!-- BEGIN LOGIN FORM -->

    <h3 class="form-title">登录</h3>

    <div class="alert alert-error hide">

        <button data-dismiss="alert" class="close"></button>

        <span>请输入账号和密码.</span>
    </div>

    <div class="control-group">

        <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->

        <label class="control-label visible-ie8 visible-ie9">账号</label>

        <div class="controls">

            <div class="input-icon left">

                <i class="icon-user"></i>

                <input type="text" name="username" id="username" placeholder="Username"
                       class="m-wrap placeholder-no-fix">
            </div>
        </div>
    </div>

    <div class="control-group" id="passwordSection">

        <label class="control-label visible-ie8 visible-ie9">密码</label>

        <div class="controls">

            <div class="input-icon left">

                <i class="icon-lock"></i>

                <input type="password" name="password" id="password" placeholder="Password"
                       class="m-wrap placeholder-no-fix">
            </div>
        </div>
    </div>

    <div class="form-actions">

    <#--@*<label class="checkbox">-->

    <#--<div class="checker">-->
    <#--<span>-->
    <#--<input type="checkbox" value="1" name="remember"></span>-->
    <#--</div>-->
    <#--记住密码-->
    <#--</label>*@-->

        <button class="btn green pull-right" id="btnLogin" type="button">
            <span id="spBtnName">登录</span> <i class="m-icon-swapright m-icon-white"></i>
        </button>
    </div>
</div>
<!-- END LOGIN -->
<!-- BEGIN COPYRIGHT -->

<div class="copyright">
    2018 &copy; X-Project.
</div>

<!-- END COPYRIGHT -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->

<script type="text/javascript" src="../static/content/media/js/jquery-1.10.1.min.js"></script>

<script type="text/javascript" src="../static/content/media/js/jquery-migrate-1.2.1.min.js"></script>

<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

<script type="text/javascript" src="../static/content/media/js/jquery-ui-1.10.1.custom.min.js"></script>

<script type="text/javascript" src="../static/content/media/js/bootstrap.min.js"></script>

<!--[if lt IE 9]>

<script src="../static/content/media/js/excanvas.min.js"></script>

<script src="../static/content/media/js/respond.min.js"></script>

<![endif]-->

<script type="text/javascript" src="../static/content/media/js/jquery.slimscroll.min.js"></script>

<script type="text/javascript" src="../static/content/media/js/jquery.blockui.min.js"></script>

<script type="text/javascript" src="../static/content/media/js/jquery.cookie.min.js"></script>

<script type="text/javascript" src="../static/content/media/js/jquery.uniform.min.js"></script>

<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->

<script type="text/javascript" src="../static/content/media/js/jquery.validate.min.js"></script>

<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->

<script type="text/javascript" src="../static/content/media/js/app.js"></script>

<script type="text/javascript" src="../static/content/media/js/login.js"></script>

<!-- END PAGE LEVEL SCRIPTS -->
<!-- END JAVASCRIPTS -->

<script type="text/javascript">

    $("#btnLogin").click(function () {
        if ($("#username").val().length < 1 || $("#password").val().length < 1) {
            alert('请输入账号密码！');
            return;
        }
        $("#spBtnName").html('正在验证...');
        $.getJSON("/author/login", {
            username: $("#username").val(),
            password: $("#password").val()
        }, function (data) {
            if (data.code == 0) {
                $("#spBtnName").html('正在跳转...');
                window.location.href = '/dashboard';
            } else {
                $("#spBtnName").html('登录');
                alert("登陆失败，错误的账号或密码!");
            }

        });

    });
    $("#passwordSection").keyup(function (event) {
        if (event.keyCode == 13) {
            $("#btnLogin").trigger("click");
        }
    });
</script>
</body>
</html>