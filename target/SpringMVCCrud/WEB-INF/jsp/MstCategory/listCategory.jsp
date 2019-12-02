<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>List Category</title>
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
                $("#category-table tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>
    <script>
        //edit
        $(document).on('click', '.edit_data', function () {
            var id = $(this).attr("id");
            $.ajax({
                url: "/categoryJson/" + id,
                method: "GET",
                dataType: "json",
                success: function (data) {
                    $('#id').val(data.id);
                    $('#name').val(data.name);
                    $('#idC').val(data.id);
                }
            });
        });
    </script>
    <script>
        //add
        $(document).on('click', '.add_data', function () {
            $('#name').val("");
        });
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
            <a href="/listCategory" class="nav-link text-white font-italic bg-secondary">
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
            <a href="/items" class="nav-link text-white font-italic">
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
    <h2 class="display-4 text-dark">Category</h2>
    <div class="separator bg-dark"></div>
    <div class="row text-white">
        <div class="col">
            <div class="container text-center">
                <!-- displaying the logged in user details. -->
                <div class="container form-group text-left" style="margin-bottom: 10px">
                    <input type="text" style="width: 300px" id="any" placeholder="Search..."/>
                    <button type="button" class="btn btn-primary float-right add_data" data-toggle="modal"
                            data-target="#modalCreateCategory">
                        Create
                    </button>
                </div>

                <br/>
                <div class="table-responsive">
                    <table class="table table-bordered text-dark">
                        <thead>
                        <tr>
                            <th width="180">Category Name</th>
                            <th width="120">Item Stocks</th>
                            <th width="60">#</th>
                        </tr>
                        </thead>
                        <tbody id="category-table">
                        <c:forEach items="${listCategory}" var="category">
                            <tr>
                                <td>${category.name}</td>
                                <td>10</td>
                                <td>
                                        <%--                                    <button type="button" class="btn btn-link" data-toggle="modal" data-target="#modalEditCategory">View</button>--%>
                                    <button type="button" class="btn btn-link edit_data" id="${category.id}" data-toggle="modal"
                                            data-target="#modalEditCategory">View</button>
                                        <%--                                    <a href="/editCategory/${category.id}">View</a>--%>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalEditCategory">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Category</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <jsp:include page="editCategory.jsp"/>
            </div>
            <%--            <div class="modal-footer">--%>
            <%--                <button type="button" class="btn btn-primary">Save changes</button>--%>
            <%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
            <%--            </div>--%>
        </div>
    </div>
</div>

<div class="modal fade" id="modalCreateCategory">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Category</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <jsp:include page="formCategory.jsp"/>
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