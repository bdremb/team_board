<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: bdrem
  Date: 11.12.2020
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<form:form>

    <c:form modelAttribute="person">
        Name:
        <tr>${person.name} </tr>
        Login:
        <tr>${person.login} </tr>


    </c:form>


</form:form>

</body>
</html>
