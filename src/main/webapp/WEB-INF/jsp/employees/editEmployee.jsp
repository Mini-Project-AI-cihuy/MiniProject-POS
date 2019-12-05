<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Employee Page</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-grid.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-reboot.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/css/homepage.css' />" rel="stylesheet"/>

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
            <a href="/listUser" class="nav-link text-white font-italic bg-secondary">
                <i class="fa fa-id-card-o mr-3 text-primary fa-fw"></i>
                Employee
            </a>
        </li>
        <li class="nav-item">
            <a href="MiniProject_POS_war/categories" class="nav-link text-white font-italic">
                <i class="fa fa-th-large mr-3 text-primary fa-fw"></i>
                Category
            </a>
        </li>
        <li class="nav-item">
            <a href="MiniProject_POS_war/suppliers" class="nav-link text-white font-italic">
                <i class="fa fa-truck mr-3 text-primary fa-fw"></i>
                Supplier
            </a>
        </li>
        <li class="nav-item">
            <a href="MiniProject_POS_war/outlets" class="nav-link text-white font-italic ">
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
</div>
<!-- End vertical navbar -->
<div class="page-content p-5 bg-white" id="content">
    <h2 class="display-4 text-dark">Update Employee</h2>
    <%--    <div class="separator bg-dark"></div>--%>
    <hr>
    <form:form action="/editUser" method="POST" modelAttribute="employee">
        <div class="row text-white">
            <div class="col">
                <div class="container text-center">
                    <fieldset id="main">
                        <div class="form-row">
                            <input type="hidden" value="${employees.id}" class="form-control" name="idEmployee" id="id"
                                   placeholder="id">
                            <input type="hidden" value="${employees.mstUser.id}" class="form-control" name="idUser"
                                   id="id2" placeholder="id">
                            <input type="hidden" value="${employees.employeeOutlet.id}" class="form-control"
                                   name="idEmployeeOutlet" id="id3" placeholder="id">
                            <div class="form-group col-md-6">
                                <label for="firstName" style="color: black;">First Name</label>
                                <input type="text" class="form-control" id="firstName" name="firstName"
                                       placeholder="First Name" value="${employees.firstName}">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="lastName" style="color: black;">Last Name</label>
                                <input type="text" class="form-control" id="lastName" name="lastName"
                                       placeholder="Last Name" value="${employees.lastName}">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="firstName" style="color: black;">Email</label>
                                <input type="text" class="form-control" id="email" name="email"
                                       placeholder="First Name" value="${employees.email}">
                            </div>
                            <div class="form-group col-md-2">
                                <label for="title" style="color: black;">Title</label>
                                <select class="custom-select my-1 mr-sm-2" name="title"
                                        id="title">
                                    <option selected>-Choose Title-</option>
                                    <option value="Mr">Mr</option>
                                    <option value="Mrs.">Mrs</option>
                                </select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="outletId" style="color: black;">Outlet Access</label>
                                <form:select class="custom-select" id="outletId" path="employeeOutlet.outletId">
                                    <form:option value="0" label="-SELECT OUTLET-"/>
                                    <form:options items="${outlets}"/>
                                </form:select>
                            </div>
                            <div class="form-group col-md-2">
                                <label for="outletId" style="color: black;">Outlet Access</label>
                                <form:select class="custom-select" id="role" path="mstUser.roleId">
                                    <form:option value="0" label="-SELECT ROLE-"/>
                                    <form:options items="${roles}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-row ">
                            <div class="form-group col-md-6">
                                <label for="username" style="color: black;">Username</label>
                                <input type="text" class="form-control" id="username" name="username"
                                       placeholder="Username" value="${employees.mstUser.username}">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="password" style="color: black;">Password</label>
                                <input type="password" class="form-control" id="password" name="password"
                                       placeholder="Password" value="${employees.mstUser.password}">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary btn-lg pull-center"> Update</button>
                    </fieldset>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="../static/js/jquery-1.11.1.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>
</body>
</html>
