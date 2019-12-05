<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Page</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-grid.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-reboot.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/css/homepage.css' />" rel="stylesheet"/>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<!-- Navbar -->
<div class="vertical-nav bg-dark" id="sidebar">
    <div class="py-4 px-3 mb-4 bg-dark">
        <div class="media d-flex align-items-center">
            <img src="https://res.cloudinary.com/mhmd/image/upload/v1556074849/avatar-1_tcnd60.png"
                 alt="..." width="65"
                 class="mr-3 rounded-circle img-thumbnail shadow-sm">
            <div class="media-body">
                <h4 class="m-0 text-white">User Name</h4>
                <p class="font-weight-light text-white mb-0">Role</p>
            </div>
        </div>
    </div>

    <p class="text-white font-weight-bold text-uppercase px-3 small pb-4 mb-0">Main</p>

    <ul class="nav flex-column bg-dark mb-0">
        <li class="nav-item">
            <a href="/listUser" class="nav-link text-white font-italic ">
                <i class="fa fa-id-card-o mr-3 text-primary fa-fw"></i>
                Employee
            </a>
        </li>
        <li class="nav-item">
            <a href="/listCategory" class="nav-link text-white font-italic">
                <i class="fa fa-th-large mr-3 text-primary fa-fw"></i>
                Category
            </a>
        </li>
        <li class="nav-item">
            <a href="/suppliers" class="nav-link text-white font-italic">
                <i class="fa fa-truck mr-3 text-primary fa-fw"></i>
                Supplier
            </a>
        </li>
        <li class="nav-item">
            <a href="/outlets" class="nav-link text-white font-italic ">
                <i class="fa fa-shopping-bag mr-3 text-primary fa-fw"></i>
                Outlet
            </a>
        </li>
        <li class="nav-item">
            <a href="MiniProject_POS_war/items" class="nav-link text-white font-italic">
                <i class="fa fa-cubes mr-3 text-primary fa-fw"></i>
                Item
            </a>
        </li>
    </ul>

    <p class="text-white font-weight-bold text-uppercase px-3 small pb-4 mb-0">Transaction</p>

    <ul class="nav flex-column bg-dark mb-0">
        <li class="nav-item">
            <a href="/" class="nav-link text-white font-italic bg-secondary">
                <i class="fa fa-id-card-o mr-3 text-primary fa-fw"></i>
                Adjustment
            </a>
        </li>
    </ul>
</div>
<!-- End vertical navbar -->
<div class="page-content p-5 bg-white" id="content">
    <div class="form-row">
        <div>
            <h4 class="display-4 text-dark">Adjustment Detail</h4>
        </div>
        <div class="ml-auto p-4 bd-highlight">
            <select name="more" id="more">
                <option selected>More</option>
                <option value="Approve">Approve</option>
                <option value="Reject">Reject</option>
                <option value="Print">Print</option>
            </select>
        </div>
    </div>
    <div class="separator bg-dark"></div>

    <div class="row">
        <div class="col">
            <div class="container text-left">
                <p>Create By: Rai</p>
                <p>Adjustment Status : ${adjustments.status}</p>
                <p>Notes :</p>
                <p>
                    ${adjustments.notes}
                </p>
            </div>
            <div class="container text-left">
                <h4>Status History</h4>
                <hr>
<%--                <p>${adjustments.adjustmentHistories.get(0).status}</p>--%>
                <c:forEach items="${adjustmentHistory}" var="adjustmentHistory">
                    <p>On ${adjustmentHistory.createOn} - ${adjustmentHistory.status}</p>
                </c:forEach>
            </div>
            <div class="container text-left">
                <h4>Adjustment Item</h4>
                <hr>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Item</th>
                        <th scope="col">In Stock</th>
                        <th scope="col">Adjustment Quantity</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${adjustmentDetail}" var="adjustmentDetails">
                    <tr>
                        <td>${adjustmentDetails.itemVariant.mstItem.name} - ${adjustmentDetails.itemVariant.name}</td>
                        <td>${adjustmentDetails.inStock}</td>
                        <td>${adjustmentDetails.actualStock}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>