<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Person page</title>
    <meta charset="UTF-8">

</head>

<body style="background-color: antiquewhite">
<h1 style="color: blue" align="center">Team BOARD</h1>
<h3 style="color: darkslategray" align="center">Уважаемый ${person.name} !</h3>
<h3 style="color: darkslategray" align="center">Добро пожаловать в MyTeam</h3>

<div> Имя: ${person.name}  </div>
<div> Фамилия: ${person.surname}</div>
<div> Ваш логин: ${person.login}</div>
<div> Возраст: ${person.extraInfo.age}</div>
<div> Город: ${person.extraInfo.city}</div>
<div> e-mail: ${person.extraInfo.email}</div>
<div> телефон : ${person.extraInfo.phoneNumber}</div>
<div> skype: ${person.extraInfo.skype}</div>

<form:form action="/team/addinfo" modelAttribute="person" method="post">

<td><form:hidden path="id"/></td>
<table>
    <tr>
        <th align="left">Age:</th>
        <td><form:input path="extraInfo.age"/></td>
        <th align="left"><form:errors cssStyle="color: orangered" path="extraInfo.age"/></th>
    </tr>
    <tr>
        <th align="left">Email:</th>
        <td><form:input path="extraInfo.email"/></td>
        <th align="left"><form:errors cssStyle="color: orangered" path="extraInfo.email"/></th>
    </tr>
    <tr>
        <th align="left">City:</th>
        <td><form:input path="extraInfo.city"/></td>
        <th align="left"><form:errors cssStyle="color: orangered" path="extraInfo.city"/></th>
    </tr>
    <tr>
        <th align="left">Phone number:</th>
        <td><form:input path="extraInfo.phoneNumber"/></td>
        <th align="left"><form:errors cssStyle="color: orangered" path="extraInfo.phoneNumber"/></th>
    </tr>
    <tr>
        <th align="left">Skype:</th>
        <td><form:input path="extraInfo.skype"/></td>
        <th align="left"><form:errors cssStyle="color: orangered" path="extraInfo.skype"/></th>
    </tr>
    <td>
        <input type="submit" value="UPDATE UPDATE">
    </td>
</table>
    </form:form>

    <td><input type="button" value="Show My team" onclick="window.location.href='/team/persons'"
               formmethod="get"></td>
    <br><br>

    <td>
        <a href="/">EXIT</a>
    </td>
</body>
</html>
