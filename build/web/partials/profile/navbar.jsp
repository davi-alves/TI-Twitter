<%-- 
    Document   : navbar
    Created on : 29/05/2012, 19:20:05
    Author     : davi
--%>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="profile">
                <img src="${baseUrl}/images/twitter_logo_top_bar.png">
            </a>
            <div class="btn-group pull-right">
                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="icon-user"></i>
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="session?action=logout">Sign Out</a></li>
                </ul>
            </div>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="active"><a href="profile">Home</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>
