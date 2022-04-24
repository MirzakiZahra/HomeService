<%--
  Created by IntelliJ IDEA.
  User: zahra
  Date: ۱۴/۰۲/۲۰۲۲
  Time: ۰۱:۳۳ قبل‌ازظهر
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/login_style.css">

</head>
<body>
<table class="table table-striped table-bordered">
    <thead class="thead-light">
    <tr>
    <th scope="col">id</th>
    <th scope="col">name</th>
    <th scope="col">description</th>
    <th scope="col">price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${subServiceDtoList}" var="subServiceDto">
        <tr>
            <td><c:out value="${subServiceDto.id}"/> </td>
            <td><c:out value="${subServiceDto.name}"/> </td>
            <td><c:out value="${subServiceDto.description}"/> </td>
            <td><c:out value="${subServiceDto.price}"/> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="${pageContext.request.contextPath}/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/register.js"></script>

</body>
</html>
