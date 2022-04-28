<%--
  Created by IntelliJ IDEA.
  User: zahra
  Date: ۲۷/۰۴/۲۰۲۲
  Time: ۰۳:۳۴ بعدازظهر
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/login_style.css">
</head>
<body>
<div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('/resources/static/image/Login.jpg');"></div>
    <div class="contents order-2 order-md-1">
        <div class="container">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-7">
                    <h3>Login to</h3>
                    <div id="massage" style="color: red">${massage}</div>

                    <form:form action="doLogin" modelAttribute="logInDto" method="post">
                        <div class="form-group first">
                            <form:input path="email" placeholder="email"/>
                            <br>
                            <form:errors path="email" cssStyle="color: red"/>
                        </div>
                        <div class="form-group last mb-3">
                            <form:password path="password" placeholder='password'/>
                            <br>
                            <form:errors path="password" cssStyle="color: red"/>
                        </div>

                        <div class="d-flex mb-5 align-items-center">
                            <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                                <input type="checkbox" checked="checked"/>
                                <div class="control__indicator"></div>
                            </label>

                        </div>
                        <p class="mb-4">Don't have an account yet? <a
                                href="${pageContext.request.contextPath}/register">Register!</a></p>
                        <input type="submit" value="Login" class="btn btn-block btn-primary"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/static/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/static/js/bootstrap.min.js"></script>
</body>
</html>