<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Disabled Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div >

    <div class=" bg-secondary col-6 m-5 justify-content-center ">
        <form action="customerSignUp" modelAttribute="customerDto" method="post">

            <div class="row mb-3 ">
                <label for="inputEmail" class="col-sm-1 col-form-label mt-5">Email</label>
                <div class="col-sm-10 mt-5">
                    <input type="email" class="form-control" id="inputEmail" placeholder="Email" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputFirstName" class="col-sm-1 col-form-label">FirstName</label>
                <div class="col-sm-10">
                    <input type="firstname" class="form-control" id="inputFirstName" placeholder="firstName" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputLastName" class="col-sm-1 col-form-label">LastName</label>
                <div class="col-sm-10">
                    <input type="lastname" class="form-control" id="inputLastName" placeholder="lastName" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputPassword" class="col-sm-1 col-form-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword" placeholder="Password" required>
                </div>
            </div>

            <%--@elvariable id="addressDto" type="java"--%>

            <form action="customerSignUp" modelAttribute="addressDto" method="post">
                <div class="row mb-3 ">
                    <label for="inputCity" class="col-sm-1 col-form-label ">city</label>
                    <div class="col-sm-10 ">
                        <input type="city" class="form-control" id="inputCity" placeholder="city" required>
                    </div>
                </div>
                <div class="row mb-3 ">
                    <label for="inputCountry" class="col-sm-1 col-form-label ">country</label>
                    <div class="col-sm-10 ">
                        <input type="country" class="form-control" id="inputCountry" placeholder="country" required>
                    </div>
                </div>
                <div class="row mb-3 ">
                    <label for="inputPlaque" class="col-sm-1 col-form-label "> plaque</label>
                    <div class="col-sm-10 ">
                        <input type=" plaque" class="form-control" id="inputPlaque" placeholder=" plaque" required>
                    </div>
                </div>
                <div class="row mb-3 ">
                    <label for="inputStreet" class="col-sm-1 col-form-label"> street</label>
                    <div class="col-sm-10 ">
                        <input type=" street" class="form-control" id="inputStreet" placeholder=" street" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-10 offset-sm-2  px-5">
                        <button type="submit" class="btn btn-primary  px-25">Sign in</button>

                    </div>
                </div>

            </form>
        </form>
    </div>
</div>
</body>
</html>