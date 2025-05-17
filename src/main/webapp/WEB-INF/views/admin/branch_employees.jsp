<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../navbar.jsp"/>

<div class="container mt-5">
    <h2 class="mb-4">Employees in ${branch.branchName}</h2>

    <form method="post" action="/admin/branches/${branch.branchID}/employees/assign" class="row g-3 mb-4">
        <div class="col-md-9">
            <label class="form-label">Select Employees</label>
            <select name="employeeID" class="form-select" required>
                <c:forEach var="emp" items="${allEmployees}">
                    <option value="${emp.employeeID}">${emp.firstName} ${emp.lastName} (${emp.user.username})</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-3 d-flex align-items-end">
            <button type="submit" class="btn btn-primary w-100">Assign</button>
        </div>
    </form>

    <h4>Assigned Employees</h4>
    <table class="table table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Shift Count</th>
            <th>Position Title</th>
            <th>Username</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="be" items="${assignedEmployees}">
            <tr>
                <td>${be.employee.employeeID}</td>
                <td>${be.employee.firstName} ${be.employee.lastName}</td>
                <td>${be.employee.salary}</td>
                <td>${be.employee.shiftCount}</td>
                <td>${be.employee.positionTitle}</td>
                <td>${be.employee.user.username}</td>
                <td>
                    <form method="post" action="/admin/branches/${branch.branchID}/employees/remove/${be.employee.employeeID}" style="display:inline;">
                        <button type="submit" class="btn btn-danger btn-sm"
                                onclick="return confirm('Remove this employee from the branch?')">Remove</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
