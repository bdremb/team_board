<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body style="background-color: antiquewhite">
<h1 style="color: blue" align="center">Team BOARD</h1>

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
