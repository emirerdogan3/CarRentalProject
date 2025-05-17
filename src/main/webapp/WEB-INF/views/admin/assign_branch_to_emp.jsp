<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../navbar.jsp"/>

<div class="container mt-5">
    <h2 class="mb-4">Assign Branch to ${employee.firstName} ${employee.lastName}</h2>

    <form action="/admin/employees/${employee.employeeID}/assign-branch" method="post">
        <div class="mb-3">
            <label class="form-label">Select Branch</label>
            <select name="branchID" class="form-select" required>
                <c:forEach var="branch" items="${branches}">
                    <option value="${branch.branchID}">${branch.branchName}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Assign</button>
        <a href="/admin/employees" class="btn btn-secondary">Back</a>
    </form>
</div>
