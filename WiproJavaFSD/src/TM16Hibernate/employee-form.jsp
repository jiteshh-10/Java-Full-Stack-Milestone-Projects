<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Employee Form</title></head>
<body>
    <h2><c:if test="${employee != null}">Edit</c:if><c:if test="${employee == null}">Add</c:if> Employee</h2>
    <form action="employee" method="post">
        <input type="hidden" name="action" value="${employee != null ? 'update' : 'add'}">
        <c:if test="${employee != null}">
            <input type="hidden" name="id" value="${employee.id}">
        </c:if>

        Name: <input type="text" name="name" value="${employee.name}" required><br>
        Email: <input type="email" name="email" value="${employee.email}" required><br>
        <input type="submit" value="Save">
    </form>
    <p><a href="employee?action=list">Back to Dashboard</a></p>
</body>
</html>