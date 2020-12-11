<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>List Persons</title>
</head>
<body>
<h1>List Persons</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Login</th>

    </tr>

    <c:forEach var="person" items="${allPersons}">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.login}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
