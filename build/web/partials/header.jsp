<%-- 
    Document   : header
    Created on : 11/05/2012, 14:03:04
    Author     : davi
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:set scope="request" var="baseUrl" value="public" />

<html>
<head>
    <title>Twitter</title>
<link rel="shortcut icon" type="image/png" href="/images/favicon.png">
<!-- Le styles -->
<link href="${baseUrl}/stylesheets/bootstrap.min.css" rel="stylesheet">
<link href="${baseUrl}/stylesheets/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${baseUrl}/stylesheets/custom.css" rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
    <c:if test="${user != null}">
        <jsp:include page="profile/navbar.jsp"/>
    </c:if>
    <c:if test="${user == null}">
        <jsp:include page="navbar.jsp"/>
    </c:if>
    <div class="container margin-top">
