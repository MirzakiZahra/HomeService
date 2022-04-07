<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>

    <title>CustomerRegister</title>

</head>
<body>



        <form:form action="customerSignUp" modelAttribute="customerDto" method="post">


                Email:<form:input path="email" />
            firstName:<form:input path="firstName" />
            lastName:<form:input path="lastName" />
            password:<form:input path="password" />

            <form:form action="customerSignUp" modelAttribute="addressDto" method="post">
                city:<form:input path="city" />
                country:<form:input path="country" />
                plaque:<form:input path="plaque" />
                street:<form:input path="street" />

                        <button type="submit" class="btn btn-primary  px-25">Sign in</button>




            </form:form>
        </form:form>

</body>
</html>