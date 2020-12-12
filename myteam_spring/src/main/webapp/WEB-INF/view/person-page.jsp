<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Person page</title>
    <meta charset="UTF-8">

</head>

<body style="background-color: antiquewhite">
<img src="resources/abracadabra.gif" alt="My team picture"/>
<h1 style="color: blue">MyTeam</h1>
<h3 style="color: darkslategray">Уважаемый ${person.name} !</h3>
<h3 style="color: darkslategray">Добро пожаловать в MyTeam</h3>

<form:form modelAttribute="person">

    <div>Имя: ${person.name}  </div>
    <br>
    <div> Фамилия: ${person.surname}</div>
    <br>
    <div> Ваш логин: ${person.login}</div>
    <br><br>
</form:form>
<td><input type="button" value="Show My team" onclick="window.location.href='/team/persons'"
           formmethod="get"></td>
<br><br>
<a href="/">EXIT</a>
</body>
</html>
