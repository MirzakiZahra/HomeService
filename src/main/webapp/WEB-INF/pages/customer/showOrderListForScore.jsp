<%--
  Created by IntelliJ IDEA.
  User: zahra
  Date: ۱۹/۰۲/۲۰۲۲
  Time: ۰۳:۲۶ بعدازظهر
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%--
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
        <h1>${orderDtoList}</h1>
        <p><b>Iterated List:</b><p>

        <ol>
        <c:forEach var="order" items="${orderDtoList}">

            <li>${order}</li>

        </c:forEach>
        </ol>
        </head>
        <body>

        </body>
        </html>
    </title>
</head>
<body>

</body>
</html>
