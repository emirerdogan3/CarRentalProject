<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../navbar.jsp"/>

<div class="container mt-5">
    <h2 class="mb-4">Branch Management</h2>

    <form action="/admin/branches/create" method="post" class="row g-3 mb-4">
        <div class="col-md-4">
            <label class="form-label">Branch Name</label>
            <input type="text" name="branchName" class="form-control" required>
        </div>




        <div class="col-md-4">
            <label class="form-label">User (Branch Owner)</label>
            <select name="userId" class="form-select" required>
                <c:forEach var="user" items="${users}">
                    <option value="${user.userID}">${user.username}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-success">Add Branch</button>
        </div>
    </form>

    <div class="mb-3">
        <input type="text" id="branchSearch" class="form-control" placeholder="Search by branch name...">
    </div>

    <table class="table table-bordered table-striped" id="branchTable">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Branch Name</th>
            <th>Owner</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody id="branchTableBody">
        <c:forEach var="branch" items="${branches}">
            <tr>
                <td>${branch.branchID}</td>
                <td>${branch.branchName}</td>
                <td>${branch.user.username}</td>
                <td>
                    <a href="/admin/branches/edit/${branch.branchID}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="/admin/cars/${branch.branchID}/cars" class="btn btn-info btn-sm">Cars</a>
                    <a href="/admin/branches/${branch.branchID}/employees" class="btn btn-primary btn-sm">Employees</a>
                    <form action="/admin/branches/delete/${branch.branchID}" method="post" style="display:inline;">
                        <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div id="noResults" class="alert alert-warning d-none">No matching branches found.</div>

    <div class="mt-3">
        <button id="prevPage" class="btn btn-secondary btn-sm">Previous</button>
        <button id="nextPage" class="btn btn-secondary btn-sm">Next</button>
    </div>
</div>

<script>
    const searchInput = document.getElementById("branchSearch");
    const tableBody = document.getElementById("branchTableBody");
    const rows = Array.from(tableBody.querySelectorAll("tr"));
    const rowsPerPage = 100;
    const noResults = document.getElementById("noResults");
    let currentPage = 1;

    function renderTable(filtered) {
        const start = (currentPage - 1) * rowsPerPage;
        const end = start + rowsPerPage;
        const paginated = filtered.slice(start, end);

        tableBody.innerHTML = "";
        paginated.forEach(row => tableBody.appendChild(row));
        noResults.classList.toggle("d-none", filtered.length > 0);
    }

    function updateTable() {
        const query = searchInput.value.toLowerCase();
        const filtered = rows.filter(row =>
            row.cells[1].textContent.toLowerCase().includes(query)
        );
        currentPage = 1;
        renderTable(filtered);
    }

    document.getElementById("prevPage").addEventListener("click", () => {
        if (currentPage > 1) {
            currentPage--;
            updateTable();
        }
    });

    document.getElementById("nextPage").addEventListener("click", () => {
        const query = searchInput.value.toLowerCase();
        const filtered = rows.filter(row =>
            row.cells[1].textContent.toLowerCase().includes(query)
        );
        const maxPage = Math.ceil(filtered.length / rowsPerPage);
        if (currentPage < maxPage) {
            currentPage++;
            renderTable(filtered);
        }
    });

    searchInput.addEventListener("keyup", updateTable);
    renderTable(rows);
</script>
