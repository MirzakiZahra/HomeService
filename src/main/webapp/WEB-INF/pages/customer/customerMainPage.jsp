<%--
  Created by IntelliJ IDEA.
  User: zahra
  Date: ۱۰/۰۲/۲۰۲۲
  Time: ۱۲:۵۹ قبل‌ازظهر
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Main</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dashboard.css">
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light box-shadow-style">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">Home Service</a>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        </ul>
        <div class="d-flex align-items-center">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="btn btn-outline-primary my-2 my-sm-0"
                       href="${pageContext.request.contextPath}/">Logout</a>
                </li>

            </ul>
        </div>

    </div>
</nav>

<div class="main">
    <div class="row">
        <div class="col-2">
            <div class="custome-sidebar">
                <div>
                    <a href="${pageContext.request.contextPath}/customer/all_orders">Orders</a>
                    <a href="${pageContext.request.contextPath}/customer/change_password">change password</a>
                    <a href="${pageContext.request.contextPath}/customer/bank">Increase credit</a>
                </div>
            </div>
        </div>
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
</body>
</html>
