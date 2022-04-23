<%--
  Created by IntelliJ IDEA.
  User: zahra
  Date: ۲۳/۰۴/۲۰۲۲
  Time: ۰۳:۳۹ بعدازظهر
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Order</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/login_style.css">
</head>
<body>
<div class="row bg-transparent ">
    <div class="col" style="background-image: url('/resources/static/image/signUpImage.jpg'); background-repeat: no-repeat"></div>


    <div class="col">
        <center>
            <h3>Create Order</h3>
            <form:form action="customerSignUp" modelAttribute="customerDto" method="post">
                <div class="form-group">
                    <form:input type="email"  path="email" placeholder="email" />
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
                    <form:input type="password" path="password" placeholder="password" />
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
        </center>
    </div>



</div>
<script src="${pageContext.request.contextPath}/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/register.js"></script>
</body>
</html>
