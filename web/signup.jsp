<%-- 
    Document   : signup
    Created on : 29/05/2012, 19:43:28
    Author     : davi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="partials/header.jsp"/>

<style type="text/css">
    .hero-unit{border: 1px solid #ddd; background-color: #FFF;}
</style>

<jsp:include page="partials/messages.jsp"/>

<div class="span8 offset2">
    <div class="hero-unit">
        <div class="signup-div">
            <h2>Participe hoje do Twitter.</h2>
            <jsp:include page="partials/forms/signupForm.jsp"/>
        </div>
    </div>
</div>
        
<jsp:include page="partials/footer.jsp" />