<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<h1>MyTeam</h1>

<body>
<br>
Пожалуйста, заполните все поля, которые сможете.<br>
<br>


<form:form action="/team/persons" modelAttribute="person" method="post">
    Name: <form:input path="name"/><br><br>
    Login: <form:input path="login"/><br><br>
    Password: <form:input path="password"/><br><br>
    Confirm password: <form:input path="confirmPassword"/><br><br>
    <input type="submit" value="ADD">

</form:form>


<a href="/">BACK</a>
</body>
</html>
