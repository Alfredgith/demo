<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>User Table</title>
    <link rel="stylesheet" th:href="@{/css/style.css}">
</head>
<body>

<h2>User List</h2>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
    </tr>
    </thead>

    <tbody>
    <tr th:each="user : ${users}">
        <td th:text="${user.id}"></td>
        <td th:text="${user.name}"></td>
        <td th:text="${user.email}"></td>
    </tr>
    </tbody>
</table>

</body>
</html>


table {
    border-collapse: collapse;
    width: 60%;
}

th, td {
    border: 1px solid #333;
    padding: 10px;
}

th {
    background-color: #f2f2f2;
}


