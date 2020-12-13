<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Persons</title>
</head>
<body style="background-color: antiquewhite">
<h1 style="color: blue" align="center">MyTeam</h1>
<table>
    <tr>

        <th>Имя</th>
        <th>Фамилия</th>
        <th>Логин</th>

    </tr>

    <c:forEach var="person" items="${allPersons}">

        <tr>

            <td>${person.name}</td>
            <td>${person.surname}</td>
            <td>${person.login}</td>

            <td><input type="button" value="Details" onclick="window.location.href='/team/persons/ + ${person.id}'"
                       formmethod="get"></td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
