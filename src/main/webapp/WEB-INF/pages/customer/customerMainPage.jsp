<%--
  Created by IntelliJ IDEA.
  User: zahra
  Date: ۱۰/۰۲/۲۰۲۲
  Time: ۱۲:۵۹ قبل‌ازظهر
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Customer Main</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/login_style.css">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Orders</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="displayChange">Change Password</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">ShowOffersForSpecificOrder</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Increase Credit</a>
            </li>
        </ul>
    </div>
</nav>
<div class="main">
    <div class="row">

        <div class="col-10">
            <div class="col-12">
                <div class="w-100 h-100 rounded pricing-text">
                    <h1></h1>
                </div>
            </div>
            <div class="col-12">
                <div class="w-100 h-100 rounded pricing-text">
                    <h1>Hi ${customerDto.firstName}</h1>
                    <h4>Your city ${addressDto.city}</h4>
                </div>
            </div>
            <div class="col-12">
                <div class="w-100 h-100 rounded Quickly-text">
                    <p>We are so glad to have you here.</p>
                </div>
            </div>

            <div class="col-xs-6 col-sm-6 col-md-6 col-lg-8 p-5 w-100 h-100 rounded" style="margin-left: 17%">
                <table class="table table-bordered table-striped text-dark">
                    <thead>
                    <tr>
                        <th colspan="2" class="text-center" style="color: white; background-color: #fb771a">
                            your information
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            first name : ${customerDto.firstName}
                        </td>
                        <td>
                            last name : ${customerDto.lastName}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            email : ${customerDto.email}
                        </td>
                    </tr>

                    </tbody>
                </table>
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
