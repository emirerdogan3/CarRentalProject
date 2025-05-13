<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Car Rental</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <c:choose>
                    <c:when test="${sessionScope.role == 'ROLE_ADMIN'}">
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/users">Users</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/branches">Branches</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/employees">Employees</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/admin/cars">Cars</a>
                        </li>
                    </c:when>
                    <c:when test="${sessionScope.role == 'ROLE_CUSTOMER'}">
                        <li class="nav-item">
                            <a class="nav-link" href="/customer/something">Customer Panel</a>
                        </li>
                    </c:when>
                    <c:when test="${sessionScope.role == 'ROLE_EMPLOYEE'}">
                        <li class="nav-item">
                            <a class="nav-link" href="/employee/something">Employee Panel</a>
                        </li>
                    </c:when>
                    <c:when test="${sessionScope.role == 'ROLE_BRANCH'}">
                        <li class="nav-item">
                            <a class="nav-link" href="/branch/something">Branch Panel</a>
                        </li>
                    </c:when>
                </c:choose>
            </ul>

            <ul class="navbar-nav ms-auto">
                <c:if test="${empty sessionScope.role}">
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/signup">Sign Up</a>
                    </li>
                </c:if>

                <c:if test="${not empty sessionScope.role}">
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
