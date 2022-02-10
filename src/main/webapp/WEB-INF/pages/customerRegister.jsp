<%--
  Created by IntelliJ IDEA.
  User: zahra
  Date: ۳۱/۰۱/۲۰۲۲
  Time: ۰۶:۰۸ بعدازظهر
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>customerRegister</title>
</head>
<body>

<%--@elvariable id="customerDto" type="CustomerServiceTest"--%>
<form:form action="customerSignUp" modelAttribute="customerDto" method="post">
    firstName: <form:input path="firstName" />
    <br><br>
    lastName: <form:input path="lastName" />
    <br><br>
    email: <form:input path="email" />
    <br><br>
    password: <form:input path="password" />
    <br><br>


    <%--@elvariable id="addressDto" type="java"--%>
    <form:form action="customerSignUp" modelAttribute="addressDto" method="post">
        city: <form:input path="city" />
        <br><br>
        country: <form:input path="country" />
        <br><br>
        plaque: <form:input path="plaque" />
        <br><br>
        street: <form:input path="street" />
        <br><br>

        <input type="submit" value="SignUp" />
    </form:form>
</form:form>

<br>
<a href="/index">go to profile</a>
</body>
</html>