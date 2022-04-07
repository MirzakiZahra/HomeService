<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>

    <title>CustomerRegister</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/login_style.css">

</head>
<body>
<div class="d-lg-flex half">
    <div class="contents order-2 order-md-1">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-7">
                    <h3>Home Service System</h3>
                    <form:form action="customerSignUp" modelAttribute="customerDto" method="post">
                        <div class="form-group">
                            <form:input path="email" placeholder="email" />
                            <br>
                        </div>
                        <div class="form-group">
                            <form:input path="firstName" placeholder="firstname" />
                            <br>
                        </div>
                        <div class="form-group">
                            <form:input path="lastName" placeholder="lastname" />
                            <br>
                        </div>
                        <div class="form-group">
                            <form:input path="password" placeholder="password" />
                            <br>
                        </div>

                        <form:form action="customerSignUp" modelAttribute="addressDto" method="post">
                            <div class="form-group">
                                <form:input path="city" placeholder="city" />
                                <br>
                            </div>
                            <div class="form-group">
                                <form:input path="country" placeholder="country" />
                                <br>
                            </div>
                            <div class="form-group">
                                <form:input path="plaque" placeholder="plaque" />
                                <br>
                            </div>
                            <div class="form-group">
                                <form:input path="street" placeholder="street" />
                                <br>
                            </div>

                            <button type="submit" class="btn btn-primary  px-25">Sign in</button>




                        </form:form>
                    </form:form>
                </div>
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