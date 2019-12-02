<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Items</title>
<%--    <security:authorize access="isAuthenticated()">--%>
<%--        authenticated as <security:authentication property="principal.username" />--%>
<%--    </security:authorize>--%>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-grid.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-reboot.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/css/homepage.css' />" rel="stylesheet"/>
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.bundle.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.js'/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script>
        //search
        $(document).ready(function () {
            $("#any").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#item-table tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
        //add
        //edit
    </script>
</head>
<body>
<div class="vertical-nav bg-dark" id="sidebar">
    <div class="py-4 px-3 mb-4 bg-dark">
        <div class="media d-flex align-items-center">
            <img src="https://res.cloudinary.com/mhmd/image/upload/v1556074849/avatar-1_tcnd60.png"
                 alt="..." width="65"
                 class="mr-3 rounded-circle img-thumbnail shadow-sm">
            <div class="media-body">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <h4 class="m-0 text-white"><span>Hello, ${pageContext.request.userPrincipal.name}</span></h4>
                    <h5 class="m-0 text-white"><sec:authentication property="principal.authorities"/></h5>
                    <span><a id="logout" href="${pageContext.servletContext.contextPath}/logout">Logout</a></span>
                </c:if>
                <%--                <h4 class="m-0 text-white">User Name</h4>--%>
                <%--                <p class="font-weight-light text-white mb-0">Role</p>--%>
            </div>
        </div>
    </div>

    <p class="text-white font-weight-bold text-uppercase px-3 small pb-4 mb-0">Main</p>

    <ul class="nav flex-column bg-dark mb-0">
        <li class="nav-item">
            <a href="/listUser" class="nav-link text-white font-italic">
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
            <a href="/outlets" class="nav-link text-white font-italic">
                <i class="fa fa-shopping-bag mr-3 text-primary fa-fw"></i>
                Outlet
            </a>
        </li>
        <li class="nav-item">
            <a href="/items" class="nav-link text-white font-italic bg-secondary">
                <i class="fa fa-cubes mr-3 text-primary fa-fw"></i>
                Items
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
    <h2 class="display-4 text-dark">Items</h2>
    <div class="separator bg-dark"></div>
    <div class="row text-white">
        <div class="col">
            <div class="container text-center">
                <div class="container form-group text-left" style="margin-bottom: 10px">
                    <input type="text" style="width: 300px" id="any" placeholder="Search..."/>
                    <button type="button" class="btn btn-primary float-right" data-toggle="modal" data-target="#modalItems">
                        Create
                    </button>
                </div>

                <br/>

                <div class="table-responsive">
                    <table class="table table-bordered text-dark">
                        <tr>
                            <th width="80">Name</th>
                            <th width="120">Category</th>
                            <th width="120">Unit Price</th>
                            <th width="120">In Stock</th>
                            <th width="120">Stock Alert</th>
                            <th width="60">#</th>
                        </tr>
                        <tbody id="item-table"
                        <c:forEach items="${items}" var="itemInventory">
                            <tr>
                                <td>${itemInventory.mstItemVariant.mstItem.name} - ${itemInventory.mstItemVariant.name}</td>
                                <td>${itemInventory.mstItemVariant.mstItem.mstCategory.name}</td>
                                <td>Rp. ${itemInventory.mstItemVariant.price}</td>
                                <td> ${itemInventory.endingQty}</td>
                                <c:if test="${itemInventory.endingQty <= itemInventory.alertAtQty}">
                                    <td>Low</td>
                                </c:if>
                                <c:if test="${itemInventory.endingQty > itemInventory.alertAtQty}">
                                    <td>Normal</td>
                                </c:if>

                                <td>
                                        <%--                                    <a href="/supplierFormEdit/${item.id}">Edit</a>--%>
<%--                                    <a href="#" name="edit" data-toggle="modal" id="${itemInventory.mstItemVariant.mstItem.id}" class="edit_data" --%>
<%--                                       data-target="#ModalAdd">Edit</a>--%>
                                    <button type="button" class="btn btn-link edit_data" id="${itemInventory.mstItemVariant.mstItem.id}" data-toggle="modal"
                                            data-target="#modalItems">Edit</button>
                                        <%--                                    <a data-toggle="modal" href="#ModalEdit">Edit</a>--%>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal Add -->
<div class="modal fade" id="modalItems">
    <div class="modal-dialog modal-dialog-centered modal-lg modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Items</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <jsp:include page="itemForm.jsp"/>
            </div>
            <%--            <div class="modal-footer">--%>
            <%--                <button type="button" class="btn btn-primary">Save changes</button>--%>
            <%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
            <%--            </div>--%>
        </div>
    </div>
</div>
</body>
</html>
