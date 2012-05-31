<%-- 
    Document   : index
    Created on : 11/05/2012, 11:22:53
    Author     : davi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="partials/header.jsp"/>

<jsp:include page="partials/messages.jsp"/>

<div class="span7">
    <div class="hero-unit">
        <h1>Bem Vindo ao Twitter.</h1>
        <p>Descubra o que está acontecendo, agora, com as pessoas e organizações que vc se importa.</p>
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
