<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../navbar.jsp"/>

<div class="container mt-5">
    <h2 class="mb-4">Employee Management</h2>

    <form action="/admin/employees/create" method="post" class="row g-3 mb-4">
        <div class="col-md-3">
            <label class="form-label">First Name</label>
            <input type="text" name="firstName" class="form-control" required>
        </div>

        <div class="col-md-3">
            <label class="form-label">Last Name</label>
            <input type="text" name="lastName" class="form-control" required>
        </div>

        <div class="col-md-3">
            <label class="form-label">Salary</label>
            <input type="text" name="salary" class="form-control">
        </div>

        <div class="col-md-3">
            <label class="form-label">Shift Count</label>
            <input type="text" name="shiftCount" class="form-control">
        </div>

        <div class="col-md-3">
            <label class="form-label">Position Title</label>
            <input type="text" name="positionTitle" class="form-control">
        </div>


        <div class="col-md-3">
            <label class="form-label">User</label>
            <select name="userId" class="form-select" required>
            <c:forEach var="user" items="${users}">
                    <option value="${user.userID}">${user.username}</option>
                </c:forEach>
            </select>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-success">Add Employee</button>
        </div>
    </form>

    <div class="mb-3">
        <input type="text" id="empSearch" class="form-control" placeholder="Search by name...">
    </div>

    <table class="table table-bordered table-striped" id="empTable">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Salary</th>
            <th>Shift Count</th>
            <th>Position Title</th>
            <th>Username</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.employeeID}</td>
                <td>${emp.firstName}</td>
                <td>${emp.lastName}</td>
                <td>${emp.salary}</td>
                <td>${emp.shiftCount}</td>
                <td>${emp.positionTitle}</td>
                <td>${emp.username}</td>
                <td>
                    <a href="/admin/employees/edit/${emp.employeeID}" class="btn btn-warning btn-sm">Edit</a>
                    <form action="/admin/employees/delete/${emp.employeeID}" method="post" style="display:inline;">
                        <button type="submit" class="btn btn-danger btn-sm"
                                onclick="return confirm('Are you sure you want to delete this employee?')">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    document.getElementById("empSearch").addEventListener("keyup", function () {
        const input = this.value.toLowerCase();
        const rows = document.querySelectorAll("#empTable tbody tr");

        rows.forEach(row => {
            const name = row.cells[1].textContent.toLowerCase();
            const surname = row.cells[2].textContent.toLowerCase();
            row.style.display = (name + " " + surname).includes(input) ? "" : "none";
        });
    });
</script>
