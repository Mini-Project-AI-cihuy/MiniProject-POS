<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>List Category</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-grid.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-reboot.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/css/homepage.css' />" rel="stylesheet"/>
    <link href="<c:url value='/resources/fontawesome/css/all.css'/>" rel="stylesheet">
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.bundle.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.js'/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
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
            <a href="#" class="nav-link text-white font-italic bg-secondary">
                <i class="fa fa-th-large mr-3 text-primary fa-fw"></i>
                Employee
            </a>
        </li>
        <li class="nav-item">
            <a href="#" class="nav-link text-white font-italic">
                <i class="fa fa-address-card mr-3 text-primary fa-fw"></i>
                Category
            </a>
        </li>
        <li class="nav-item">
            <a href="#" class="nav-link text-white font-italic">
                <i class="fa fa-cubes mr-3 text-primary fa-fw"></i>
                Supplier
            </a>
        </li>
        <li class="nav-item">
            <a href="#" class="nav-link text-white font-italic">
                <i class="fa fa-picture-o mr-3 text-primary fa-fw"></i>
                Outlet
            </a>
        </li>
        <li class="nav-item">
            <a href="#" class="nav-link text-white font-italic">
                <i class="fa fa-picture-o mr-3 text-primary fa-fw"></i>
                Item
            </a>
        </li>
    </ul>
</div>
<!-- End vertical navbar -->

<!-- Page content holder -->
<div class="page-content p-5 bg-white" id="content">
    <!-- Toggle button -->
    <%--    <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4"><i class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Toggle</small></button>--%>

    <!-- Demo content -->
    <h2 class="display-4 text-dark">Category</h2>
    <div class="separator bg-dark"></div>
    <div class="row text-white">
        <div class="col">
            <div class="container text-center">
                <br/>
                <form:form method="post" action="/saveCategory" commandName="category" class="form-horizontal">
                    <form:hidden path="id"/>
                    <div class="form-group">
                            <%--        <label class="control-label col-md-3">Category Name</label>--%>
                        <div class="col-md-7">
                            <form:input type="text" class="form-control" path="name"/>
                            <form:errors path="name" cssStyle="color:#FF000" />
                        </div>
                    </div>
                    <button type="button" class="btn btn-danger float-left" ONCLICK="location.href='/deactivateCategory/${category.id}'"><i class="fas fa-times"></i></button>
                    <button type="reset" class="btn btn-primary float-left">Cancel</button>
                    <input type="submit" class="btn btn-primary float-right" value="Save"/>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>

<%--<body>--%>
<%--<h1>Category</h1>--%>
<%--<form:form method="post" action="/saveCategory" commandName="category" class="form-horizontal">--%>
<%--    <form:hidden path="id"/>--%>
<%--    <div class="form-group">--%>
<%--&lt;%&ndash;        <label class="control-label col-md-3">Category Name</label>&ndash;%&gt;--%>
<%--        <div class="col-md-7">--%>
<%--            <form:input type="text" class="form-control" path="name"/>--%>
<%--            <form:errors path="name" cssStyle="color:#FF000" />--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <button type="button" class="btn btn-danger float-left" ONCLICK="location.href='/deactivateCategory/${category.id}'"><i class="fas fa-times"></i></button>--%>
<%--    <button type="reset" class="btn btn-primary float-left">Cancel</button>--%>
<%--    <input type="submit" class="btn btn-primary float-right" value="Save"/>--%>
<%--</form:form>--%>
<%--<button type="button" class="btn btn-danger" ONCLICK="location.href='/deactivateCategory/${category.id}'"><span class="glyphicon glyphicon-remove"></span></button>--%>
<%--<button type="reset" class="btn btn-primary">Cancel</button>--%>
<%--<button type="button" class="btn btn-primary" ONCLICK="location.href='/formCategory'">Cancel</button>--%>
<%--</body>--%>
</html>