<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body style="background-color: antiquewhite">
<h1 style="color: blue">MyTeam</h1>
<br>
Пожалуйста, заполните все поля, которые сможете.<br>
<br>
<form:form action="/team/persons" modelAttribute="person" method="post">
<table>
    <tr>
        <th align="left">Name:</th>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <th align="left">Login:</th>
        <td><form:input path="login"/></td>
    </tr>
    <tr>
        <th align="left">Password:</th>
        <td><form:password path="password"/></td>
    </tr>
    <tr>
        <th align="left">Confirm password:</th>
        <td><form:password path="confirmPassword"/></td>
    </tr>
    <tr>
        <td></td>
        <td>Введите пароль и запомните его.</td>
    </tr>


    <td>
        <input type="submit" value="Register">
    </td>
    </form:form>


</table>
<td><input type="button" value="START PAGE" onclick="window.location.href='/'"></td><br>

</body>
</html>
