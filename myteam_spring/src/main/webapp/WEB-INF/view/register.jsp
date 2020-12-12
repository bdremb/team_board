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
        <th align="left">Имя:</th>
        <td><form:input path="name"/></td>
        <th><form:errors cssStyle="color: orangered" path="name"/></th>

    </tr>
    <tr>
        <th align="left">Фамилия:</th>
        <td><form:input path="surname"/></td>
        <th><form:errors cssStyle="color: orangered" path="surname"/></th>
    </tr>
    <tr>
        <th> мужчина <form:radiobutton path="gender" value="man"/><br>
            женщина <form:radiobutton path="gender" value="woman"/></th>


    </tr>

    <tr>
        <th align="left">Логин:</th>
        <td><form:input path="login"/></td>
        <th><form:errors cssStyle="color: orangered" path="login"/></th>
    </tr>
    <tr>
        <th align="left">Пароль:</th>
        <td><form:password path="password"/></td>
        <th><form:errors cssStyle="color: orangered" path="password"/></th>
    </tr>
    <tr>
        <th align="left">Потдвердите пароль:</th>
        <td><form:password path="confirmPassword"/></td>
        <th><form:errors cssStyle="color: orangered" path="confirmPassword"/></th>
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
<td><input type="button" value="START PAGE" onclick="window.location.href='/'"></td>
<br>

</body>
</html>
