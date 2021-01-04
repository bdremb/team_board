<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>

<body style="background-color: antiquewhite">
<h1 style="color: blue" align="center">MyTeam</h1>
<h3>Enter your login and password:</h3>

<form:form action="/team/login" modelAttribute="person" method="post">
<table>
    <tr>
        <th align="left">Login:</th>
        <td><form:input path="login"/></td>
    </tr>
    <tr>
        <th align="left">Password:</th>
        <td><form:password path="password"/></td>
    </tr>
    <td>
        <input type="submit" value="OK">
    </td>
    </form:form>
</table>

<td><input type="button" value="START PAGE" onclick="window.location.href='/'"></td>
<br>

</body>
</html>
