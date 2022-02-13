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
    <title>password</title>
</head>
<body>
<form:form action="ChangePassword"  method="post">
    <label>
        <input type="text" name="oldPass"/>
    </label>
    <br><br>
    <label>
        <input type="text" name="newPass"/>
    </label>
    <br><br>
    <label>
        <input type="text" name="email"/>
    </label>
    <br><br>

    <input type="submit" value="SignUp" />
</form:form>
</body>
</html>
