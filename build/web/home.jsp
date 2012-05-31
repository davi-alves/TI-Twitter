<%-- 
    Document   : index
    Created on : 11/05/2012, 11:22:53
    Author     : davi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="partials/header.jsp"/>

<c:if test="${message != null && message.getText() != null}">
    <div class="alert alert-${message.getType()} span10">
        <a class="close" data-dismiss="alert" href="#">�</a>
        <strong>ERROR!</strong>
        ${message.getText()}
    </div>
</c:if>

<div class="span7">
    <div class="hero-unit">
        <h1>Bem Vindo ao Twitter.</h1>
        <p>Descubra o que est� acontecendo, agora, com as pessoas e organiza��es que vc se importa.</p>
        <p style="height:38px"></p>
    </div>
</div>

<div class="span3 well login-div-home">
    <jsp:include page="partials/forms/loginForm.jsp" />
</div>

<div class="span3 well signup-div-home">
    <h4 class="nav-header">Novo no Twitter?</h4>
    <jsp:include page="partials/forms/signupIndex.jsp" />
</div>

<jsp:include page="partials/footer.jsp" />
