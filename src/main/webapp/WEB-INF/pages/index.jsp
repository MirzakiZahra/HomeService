<%--
  Created by IntelliJ IDEA.
  User: zahra
  Date: ۰۹/۰۲/۲۰۲۲
  Time: ۱۰:۵۱ بعدازظهر
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/login_style.css">
</head>
<body>
<div class="row bg-transparent ">
    <div class="col mx-auto">
        <img src="/resources/static/image/HomeService.jpg" class="img-fluid" alt="Responsive image">
        <div class="row">
        <div class="col"></div>
        <div class="col">
            <a href="displaySignUp" class="btn btn-primary  mx-auto" role="button" aria-pressed="true">Expert SignUp</a></div>
        <div class="col">
            <a href="displaySignUp" class="btn btn-primary  mx-auto" role="button" aria-pressed="true">Expert LogIn</a></div>
        <div class="col"></div></div>
    </div>
    <div class="col mx-auto">
        <img src="/resources/static/image/Customer.jpg" class="img-fluid" alt="Responsive image">
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <a href="displaySignUp" class="btn btn-primary  mx-auto" role="button" aria-pressed="true">User SignUp</a>
                </div>
            <div class="col">
                <a href="displaySignUp" class="btn btn-primary  mx-auto" role="button" aria-pressed="true">User LogIn</a></div>
            <div class="col"></div></div>
    </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/register.js"></script>
</body>
</html>
