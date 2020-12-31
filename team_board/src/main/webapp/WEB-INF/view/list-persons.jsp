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

        <th>NAME</th>
        <th>   </th>
        <th> SURNAME </th>
        <th>   </th>
        <th>LOGIN</th>
        <th>   </th>
        <th>AGE</th>
        <th>   </th>
        <th>CITY</th>
        <th>   </th>
        <th>E-MAIL</th>
        <th>   </th>
        <th>Skype</th>
        <th>   </th>
        <th>Phone number</th>
    </tr>

    <c:forEach var="person" items="${allPersons}">

        <tr>

            <td>${person.name}</td>
            <th>  </th>
            <td>${person.surname}</td>
            <th>  </th>
            <td>${person.login}</td>
            <th>  </th>
            <td>${person.extraInfo.age}</td>
            <th>  </th>
            <td>${person.extraInfo.city}</td>
            <th>  </th>
            <td>${person.extraInfo.email}</td>
            <th>  </th>
            <td>${person.extraInfo.skype}</td>
            <th>  </th>
            <td>${person.extraInfo.phoneNumber}</td>

            <td><input style="color: coral" type="button" value="Delete" onclick="window.location.href='/team/persons/delete/ + ${person.id}'"></td><br>
            <td><input style="color: blue" type="button" value="Update" onclick="window.location.href='/team/persons/update/ + ${person.id}'"></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
