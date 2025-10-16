<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Employee Dashboard</title></head>
<body>
    <h2>Employee Management</h2>
    <a href="employee-form.jsp">Add New Employee</a> |
    <a href="employee?action=edit">Modify My Profile</a> |
    <a href="logout">Logout</a>
    <hr>

    <form action="employee" method="get">
        <input type="hidden" name="action" value="find">
        Find Employee by ID: <input type="number" name="id">
        <input type="submit" value="Search">
    </form>
    <p style="color:blue;">${message}</p> <h3>All Employees</h3>
    <table border="1" width="100%">
        <tr><th>ID</th><th>Name</th><th>Email</th><th>Designation</th><th>Actions</th></tr>
        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.id}</td><td>${emp.name}</td><td>${emp.email}</td><td>${emp.designation}</td>
                <td><a href="employee?action=delete&id=${emp.id}" onclick="return confirm('Are you sure?')">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>