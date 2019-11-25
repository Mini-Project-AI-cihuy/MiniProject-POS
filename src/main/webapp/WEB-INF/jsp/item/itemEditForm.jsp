<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Edit Supplier Page</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-grid.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-reboot.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/css/homepage.css' />" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="/resources/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="page-content p-5 bg-white" id="content">

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
                <a href="/index" class="nav-link text-white font-italic">
                    <i class="fa fa-id-card-o mr-3 text-primary fa-fw"></i>
                    Employee
                </a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link text-white font-italic">
                    <i class="fa fa-th-large mr-3 text-primary fa-fw"></i>
                    Category
                </a>
            </li>
            <li class="nav-item">
                <a href="/suppliers" class="nav-link text-white font-italic bg-secondary">
                    <i class="fa fa-truck mr-3 text-primary fa-fw"></i>
                    Supplier
                </a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link text-white font-italic">
                    <i class="fa fa-shopping-bag mr-3 text-primary fa-fw"></i>
                    Outlet
                </a>
            </li>
            <li class="nav-item">
                <a href="#" class="nav-link text-white font-italic">
                    <i class="fa fa-cubes mr-3 text-primary fa-fw"></i>
                    Item
                </a>
            </li>
        </ul>
    </div>
    <!-- End vertical navbar -->

    <div class="row display-4">
        <i class="fa fa-arrow-left" style="color:black;margin: 10px" onclick="history.back()"></i>
        <h2 class="display-4 text-dark">Edit Supplier Data</h2>
    </div>
    <div class="separator bg-dark"></div>
    <div class="container-fluid">
        <form:form method="post" action="/edit" class="form-horizontal" commandName="supplierEdit">
            <form:hidden path="id"/>
            <div class="form-group">
                <label class="control-label col-md-6">Supplier Name</label>
                <div class="col-md-12">
                    <form:input type="text" class="form-control" path="name"/>
                        <%--                <form:errors path="name" cssStyle="color:#FF000" />--%>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-6">Address</label>
                <div class="col-md-12">
                    <form:textarea type="text" class="form-control" path="address"/>
                </div>
            </div>

            <div class="row col-md-12">
                <div class="form-group">
                    <label class="control-label col-md-6">Province</label>
                    <div class="col-md-12">
                        <form:select path="provinceId" class="form-control">
                            <form:option value="0" label="-SELECT PROVINCE-"/>
                            <form:options items="${province}"/>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-6">Region</label>
                    <div class="col-md-12">
                        <form:select path="regionId" class="form-control">
                            <form:option value="0" label="-SELECT REGION-"/>
                            <form:options items="${region}"/>
                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-6">District</label>
                    <div class="col-md-12">
                        <form:select path="districtId" class="form-control">
                            <form:option value="0" label="-SELECT DISTRICT-"/>
                            <form:options items="${district}"/>
                        </form:select>
                    </div>
                </div>
            </div>

            <div class="row col-md-12">
                <div class="form-group">
                    <label class="control-label col-md-6">Postal Code</label>
                    <div class="col-md-12">
                        <form:input type="text" class="form-control" path="postalCode"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-6">Phone</label>
                    <div class="col-md-12">
                        <form:input type="text" class="form-control" path="phone"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-6">Email</label>
                    <div class="col-md-12">
                        <form:input type="text" class="form-control" path="email"/>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col text-right">
                    <input type="reset" class="btn btn-danger" value="Cancel"/>
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
