<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../navbar.jsp"/>

<div class="container mt-5">
    <h2 class="mb-4">Edit Branch</h2>

    <form action="/admin/branches/update" method="post" class="row g-3">
        <input type="hidden" name="branchID" value="${branch.branchID}"/>

        <div class="col-md-4">
            <label class="form-label">Branch Name</label>
            <input type="text" name="branchName" class="form-control" value="${branch.branchName}" required>
        </div>





        <div class="col-md-4">
            <label class="form-label">User (Branch Owner)</label>
            <select name="userId" class="form-select" required>
                <c:forEach var="user" items="${users}">
                    <option value="${user.userID}" <c:if test="${user.userID == branch.user.userID}">selected</c:if>>${user.username}</option>
                </c:forEach>
            </select>
        </div>

        <div class="col-12">
            <button type="submit" class="btn btn-primary">Update Branch</button>
            <a href="/admin/branches" class="btn btn-secondary">Cancel</a>
        </div>
    </form>
</div>
