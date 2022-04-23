<%--
  Created by IntelliJ IDEA.
  User: zahra
  Date: ۱۲/۰۲/۲۰۲۲
  Time: ۰۴:۱۱ بعدازظهر
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Change Password</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/login_style.css">
</head>
</head>
<body style="background-color:powderblue;">
<div id="login">
    <h3 class="text-center text-white pt-5">Change PassWord</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
<div class="row bg-transparent ">
    <div class="col" ></div>
    <div class="col">
<form:form action="ChangePassword"  method="post">
    <label>
        <label>oldPass</label>
        <input type="text" name="oldPass"/>
    </label>
    <br><br>
    <label>
        <label>newPass</label>
        <input type="text" name="newPass"/>
    </label>
    <br><br>
    <label>
        <label>email</label>
        <input type="text" name="email"/>
    </label>
    <br><br>

    <input type="submit" value="Change Pass" />
</form:form>
    </div>
    <div class="col"></div>
</div>
</div>
</div>
</div>
<script src="${pageContext.request.contextPath}/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/register.js"></script>
</body>
</html>
