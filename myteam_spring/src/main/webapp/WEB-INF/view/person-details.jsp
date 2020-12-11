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
<body style="background-color: antiquewhite">
<h1 style="color: blue">MyTeam</h1>

<table style="color: darkgreen">
    <tr>
        <th><b>Name</b></th>
        <th><b>Login</b></th>
    </tr>


    <c:form modelAttribute="person">
        <tr>
            <td>${person.name} </td>

            <td>${person.login} </td>
        </tr>

    </c:form>


</table>

<td><input style="color: coral" type="button" value="Delete" onclick="window.location.href='/team/persons/delete/ + ${person.id}'"></td><br>
<td><input style="color: blue" type="button" value="Update" onclick="window.location.href='persons/update/ + ${person.id}'" formmethod="post"></td>

</body>
</html>
