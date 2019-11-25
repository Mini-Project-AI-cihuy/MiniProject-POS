<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<head>
    <title>Supplier</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-grid.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-reboot.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/css/homepage.css' />" rel="stylesheet"/>
    <script src="/resources/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.js"></script>
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
                <i class="fa fa-id-card-o mr-3 text-primary fa-fw bg-secondary"></i>
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
            <a href="/suppliers" class="nav-link text-white font-italic">
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


<%--<!-- Page content holder -->--%>
<%--<div class="page-content p-5 bg-white" id="content">--%>
<%--    <!-- Toggle button -->--%>
<%--    &lt;%&ndash;    <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4"><i class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Toggle</small></button>&ndash;%&gt;--%>

<%--    <!-- Demo content -->--%>
<%--    <h2 class="display-4 text-dark">Supplier</h2>--%>
<%--    <div class="separator bg-dark"></div>--%>
<%--    <div class="row text-white">--%>
<%--        <div class="col">--%>
<%--            <div class="container text-center">--%>
<%--                <div class="container form-group text-left" style="margin-bottom: 10px">--%>
<%--                    <form method="post" action="/search" class="form-horizontal float-left">--%>
<%--                        <input type="text" style="width: 300px" id="param"/>--%>
<%--                        <button type="button" class="btn btn-primary" ONCLICK="href='/search'">Search</button>--%>
<%--                    </form>--%>
<%--                    <button type="button" class="btn btn-danger float-right" data-toggle="modal"--%>
<%--                            data-target="#ModalAdd">--%>
<%--                        Create--%>
<%--                    </button>--%>
<%--                </div>--%>

<%--                <br/>--%>

<%--                <div class="table-responsive">--%>
<%--                    <table class="table table-bordered text-dark">--%>
<%--                        <tr>--%>
<%--                            <th width="80">Name</th>--%>
<%--                            <th width="120">Address</th>--%>
<%--                            <th width="120">Phone</th>--%>
<%--                            <th width="120">Email</th>--%>
<%--                            <th width="120">Province</th>--%>
<%--                            <th width="60">#</th>--%>
<%--                        </tr>--%>
<%--                        <c:forEach items="${suppliers}" var="supplier">--%>
<%--                            <tr>--%>
<%--                                <td>${supplier.name}</td>--%>
<%--                                <td>${supplier.address}</td>--%>
<%--                                <td>${supplier.phone}</td>--%>
<%--                                <td>${supplier.email}</td>--%>
<%--                                <td>${supplier.mstProvinces.name}</td>--%>
<%--                                <td>--%>
<%--                                    <a href="/supplierFormEdit/${supplier.id}">Edit</a>--%>
<%--&lt;%&ndash;                                    <a data-toggle="modal" href="#ModalEdit">Edit</a>&ndash;%&gt;--%>
<%--                                    <a href="/deleteSupplier/${supplier.id}">Delete</a>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                        </c:forEach>--%>
<%--                    </table>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<!-- Modal Add -->--%>
<%--<div class="modal" id="ModalAdd">--%>
<%--    <div class="modal-dialog modal-lg">--%>
<%--        <div class="modal-content">--%>

<%--            <!-- Modal Header -->--%>
<%--            <div class="modal-header">--%>
<%--                <h4 class="modal-title">Add New Suppliers</h4>--%>
<%--                <button type="button" class="close" data-dismiss="modal">&times;</button>--%>
<%--            </div>--%>

<%--            <!-- Modal body -->--%>
<%--            <div class="modal-body">--%>
<%--                <jsp:include page="itemForm.jsp"/>--%>
<%--            </div>--%>

<%--            <!-- Modal footer -->--%>
<%--            &lt;%&ndash;            <div class="modal-footer">&ndash;%&gt;--%>
<%--            &lt;%&ndash;                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>&ndash;%&gt;--%>
<%--            &lt;%&ndash;            </div>&ndash;%&gt;--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<!-- Modal edit -->--%>
<%--<div class="modal" id="ModalEdit">--%>
<%--    <div class="modal-dialog modal-lg">--%>
<%--        <div class="modal-content">--%>

<%--            <!-- Modal Header -->--%>
<%--            <div class="modal-header">--%>
<%--                <h4 class="modal-title">Edit New Suppliers</h4>--%>
<%--                <button type="button" class="close" data-dismiss="modal">&times;</button>--%>
<%--            </div>--%>

<%--            <!-- Modal body -->--%>
<%--            <div class="modal-body">--%>
<%--                <jsp:include page="itemEditForm.jsp"/>--%>
<%--            </div>--%>

<%--            <!-- Modal footer -->--%>
<%--            &lt;%&ndash;            <div class="modal-footer">&ndash;%&gt;--%>
<%--            &lt;%&ndash;                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>&ndash;%&gt;--%>
<%--            &lt;%&ndash;            </div>&ndash;%&gt;--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
</body>
