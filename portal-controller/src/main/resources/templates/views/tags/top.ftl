<div class="navbar-inner">

    <div class="container-fluid">

        <!-- BEGIN LOGO -->

        <a class="brand" href="/">

            <img src="../static/content/media/image/m-logo.jpeg" alt="logo"/>
        </a>

        <!-- END LOGO -->
        <!-- BEGIN RESPONSIVE MENU TOGGLER -->

        <a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

            <img src="../static/content/media/image/menu-toggler.png" alt=""/>
        </a>

        <!-- END RESPONSIVE MENU TOGGLER -->
        <!-- BEGIN TOP NAVIGATION MENU -->

        <ul class="nav pull-right">

            <!-- BEGIN NOTIFICATION DROPDOWN -->

            <!-- END TODO DROPDOWN -->
            <!-- BEGIN USER LOGIN DROPDOWN -->

            <li class="dropdown user">

                <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                    <img alt="" src="../static/content/media/image/avatar.png"
                         style="height:29px; vertical-align:middle;"/>


                        <#if Session["user"]?exists>
                        <span class="username"> ${Session["user"].getUserName()}</span>
                        <#else>
                         <span class="username">admin</span>
                        </#if>

                    <i class="icon-angle-down"></i>
                </a>

                <ul class="dropdown-menu">

                    <li ><a href="#"><i class="icon-user"></i> 修改密码</a></li>

                        <#if Session["user"]?exists>
                         <li><a href="/portalusers/list"><i class="icon-user"></i>后台管理</a></li>
                        </#if>
                    <li><a href="/author/logout"><i class="icon-key"></i> 退出</a></li>
                </ul>
            </li>

            <!-- END USER LOGIN DROPDOWN -->
        </ul>

        <!-- END TOP NAVIGATION MENU -->
    </div>
</div>