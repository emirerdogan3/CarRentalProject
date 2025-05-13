<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../navbar.jsp"/>

<div class="container mt-5">
    <h2 class="mb-4">Edit Employee</h2>

    <form action="/admin/employees/update" method="post" class="row g-3">
        <input type="hidden" name="employeeID" value="${employee.employeeID}" />

        <div class="col-md-4">
            <label class="form-label">First Name</label>
            <input type="text" name="firstName" class="form-control" value="${employee.firstName}" required>
        </div>

        <div class="col-md-4">
            <label class="form-label">Last Name</label>
            <input type="text" name="lastName" class="form-control" value="${employee.lastName}" required>
        </div>

        <div class="col-md-4">
            <label class="form-label">Salary</label>
            <input type="text" name="salary" class="form-control" value="${employee.salary}">
        </div>

        <div class="col-md-4">
            <label class="form-label">Shift Count</label>
            <input type="text" name="shiftCount" class="form-control" value="${employee.shiftCount}">
        </div>

        <div class="col-md-4">
            <label class="form-label">Position Title</label>
            <input type="text" name="positionTitle" class="form-control" value="${employee.positionTitle}">
        </div>


        <div class="col-md-6">
            <label class="form-label">User</label>
            <select name="userId" class="form-select" required>
                <c:forEach var="user" items="${users}">
                    <option value="${user.userID}" ${user.userID == employee.user.userID ? 'selected' : ''}>
                            ${user.username}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="/admin/employees" class="btn btn-secondary">Cancel</a>
        </div>
    </form>
</div>
