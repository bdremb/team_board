
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Person page</title>
    <meta charset="UTF-8">
</head>
<h1>Уважаемый ${person.name} !</h1><br>
<h1>Добро пожаловать в MyTeam</h1>
<body>
Имя: ${person.name}
<br><br>
Ваш логин: ${person.login}<br><br>
<a href="/">EXIT</a>
</body>
</html>
