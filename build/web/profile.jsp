<%--
    Document   : index
    Created on : 11/05/2012, 11:22:53
    Author     : davi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="partials/header.jsp"/>

<jsp:include page="partials/messages.jsp"/>

<style type="text/css">
    body {
        background-image: url(public/images/bg.png);
        background-position: left 40px;
        background-attachment: fixed;
        background-repeat: repeat;
        background-repeat: no-repeat;
        background-color: 
            #C0DEED;
    }
    #user-status{margin-top: 20px;}
</style>

<div class="row">
    <div class="span3">
        <div class="well sidebar-nav">
            <ul class="nav nav-list" id="user-status">
                <li><h3>${user.getName()}</h3></li>
                <li>
                    <ul>
                        <li> 4 TWEETS</li>
                        <li> 21 FALLOWING</li>
                        <li> 4 FALLOWERS</li>
                    </ul>
                </li>
                <li>
                    <jsp:include page="partials/forms/tweet.jsp"/>
                </li>
            </ul>
        </div><!--/.well -->
    </div><!--/span-->
    <div class="span9">
        <div class="hero-unit">
            <h1>Hello, world!</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a class="btn btn-primary btn-large">Learn more �</a></p>
        </div>
        <div class="row-fluid">
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn" href="#">View details �</a></p>
            </div><!--/span-->
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn" href="#">View details �</a></p>
            </div><!--/span-->
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn" href="#">View details �</a></p>
            </div><!--/span-->
        </div><!--/row-->
        <div class="row-fluid">
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn" href="#">View details �</a></p>
            </div><!--/span-->
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn" href="#">View details �</a></p>
            </div><!--/span-->
            <div class="span4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn" href="#">View details �</a></p>
            </div><!--/span-->
        </div><!--/row-->
    </div><!--/span-->
</div>

<jsp:include page="partials/footer.jsp" />
