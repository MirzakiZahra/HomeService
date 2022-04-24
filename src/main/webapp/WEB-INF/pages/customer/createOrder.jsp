<%--
  Created by IntelliJ IDEA.
  User: zahra
  Date: ۲۳/۰۴/۲۰۲۲
  Time: ۰۳:۳۹ بعدازظهر
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <form:form action="orderCreate"  method="post">
                <div class="form-group">
                    <input type="flost" name="cost"   placeholder="cost" />
                    <br>
                </div>
                <div class="form-group">
                    <input type="text" name="explanation"   placeholder="explanation" />
                    <br>
                </div>
                <div class="form-group">
                    <input type="text"  name="beggingDate"   placeholder="beggingDate,dd/MM/yyyy,HH:mm" />
                    <br>
                </div>
                <div class="form-group">
                    <input type="text" name="endingDate"   placeholder="endingDate,dd/MM/yyyy,HH:mm" />
                    <br>
                </div>
                <div class="form-group">
                    <input type="text" name="address"   placeholder="address" />
                    <br>
                </div>
                <div class="form-group">
                    <input type="email" name="email"   placeholder="email" />
                    <br>
                </div>
                <div class="form-group">
                    <input type="int" name="subServiceId"   placeholder="subServiceId" />
                    <br>
                </div>

                    <button type="submit" class="btn btn-primary  px-25">Create Order</button>




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
