<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Outlet Page</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-grid.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-reboot.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/css/homepage.css' />" rel="stylesheet"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="/resources/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.js"></script>
    <%--    <script src="/resources/jquery/jquery-3.4.1.slim.js"></script>--%>

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
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <h4 class="m-0 text-white"><span>Hello, ${pageContext.request.userPrincipal.name}</span></h4>
                    <h5 class="m-0 text-white"><sec:authentication property="principal.authorities"/></h5>
                    <span><a id="logout" href="${pageContext.servletContext.contextPath}/logout">Logout</a></span>
                </c:if>
            </div>
        </div>
    </div>

    <p class="text-white font-weight-bold text-uppercase px-3 small pb-4 mb-0">Main</p>

    <ul class="nav flex-column bg-dark mb-0">
        <li class="nav-item">
            <a href="listEmployee" class="nav-link text-white font-italic">
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
            <a href="/outlets" class="nav-link text-white font-italic bg-secondary">
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
    <br>
    <sec:authorize access="hasAuthority('Back Office') and isAuthenticated()">
        <p class="text-white font-weight-bold text-uppercase px-3 small pb-4 mb-0">Transaction</p>

        <ul class="nav flex-column bg-dark mb-0">
            <li class="nav-item">
                <a href="/listRequest" class="nav-link text-white font-italic">
                    <i class="fa fa-id-card-o mr-3 text-primary fa-fw"></i>
                    Purchase Request
                </a>
            </li>
            <li class="nav-item">
                <a href="/listOrder" class="nav-link text-white font-italic">
                    <i class="fa fa-th-large mr-3 text-primary fa-fw"></i>
                    Purchase Order
                </a>
            </li>
            <li class="nav-item">
                <a href="/adjustment" class="nav-link text-white font-italic">
                    <i class="fa fa-truck mr-3 text-primary fa-fw"></i>
                    Adjustment
                </a>
            </li>
            <li class="nav-item">
                <a href="/transferStock" class="nav-link text-white font-italic">
                    <i class="fa fa-shopping-bag mr-3 text-primary fa-fw"></i>
                    Transfer Stock
                </a>
            </li>
            <li class="nav-item">
                <a href="/salesOrder" class="nav-link text-white font-italic">
                    <i class="fa fa-cubes mr-3 text-primary fa-fw"></i>
                    Sales Order
                </a>
            </li>
        </ul>
    </sec:authorize>
</div>
<!-- End vertical navbar -->
<div class="page-content p-5 bg-white" id="content">
    <h2 class="display-4 text-dark">Outlets</h2>
    <div class="separator bg-dark"></div>
    <div class="row text-white">
        <div class="col">
            <div class="container text-center">
                <!-- Form Search-->
                <div class="d-flex bd-highlight mb-3">
                    <div class="p-2 bd-highlight">
                        <input id="any" class="form-control mr-sm-2" type="search" placeholder="Search"
                               aria-label="Search">
                    </div>
                    <div class="ml-auto p-2 bd-highlight">
                        <sec:authorize access="hasAuthority('Administrator') and isAuthenticated()">
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#createOutletModal">
                                Create
                            </button>
                        </sec:authorize>
                    </div>
                </div>
                <!-- Tabel Outlet -->
                <div>
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Address</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Email</th>
                            <th scope="col">#</th>
                        </tr>
                        </thead>
                        <tbody id="outlet-table">
                        <c:forEach items="${outlets}" var="outlets">
                            <tr>
                                <th>${outlets.name}</th>
                                <td>${outlets.address}</td>
                                <td>${outlets.phone}</td>
                                <td>${outlets.email}</td>
                                <sec:authorize access="hasAuthority('Administrator') and isAuthenticated()">
                                    <td>
                                        <a onclick="showEditValue(${outlets.id})">
                                            <i class="fa fa-pencil col-1"></i>
                                        </a>
                                        <a href="/deleteOutlet/${outlets.id}" name="delete" class="delete_outlet">
                                            <i class="fa fa-trash col-1"></i>
                                        </a>
                                    </td>
                                </sec:authorize>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal Edit Outlet -->
<div class="modal fade" id="editOutletModal" tabindex="-1" role="dialog" aria-labelledby="ModalEdit"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ModalEdit">Input Outlet</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <%@include file="modalEdit.jsp" %>
            </div>
        </div>
    </div>
</div>

<!-- Modal Input Outlet -->
<div class="modal fade" id="createOutletModal" tabindex="-1" role="dialog" aria-labelledby="ModalInput"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="ModalInput">Input Outlet</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <%--                <%@include file="modalInput.jsp" %>--%>
                <form:form method="POST" action="/createOutlet" class="form-horizontal" modelAttribute="edit">
                    <div class="form-group">
                        <label for="name" class="col-form-label">Outlet Name</label>
                        <form:input type="text" class="form-control" path="name"/>
                    </div>
                    <div class="form-group">
                        <label for="address" class="col-form-label">Address</label>
                        <form:textarea class="form-control" id="address" path="address"/>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <form:select id="provinceInput" class="form-control" name="province" path="provinceId">
                                <form:option value="0" label="Select Province"/>
                                <form:options items="${province}"/>
                            </form:select>
                        </div>
                        <div class="form-group col-md-4">
                            <form:select id="regionInput" class="form-control" name="region" path="regionId">
                                <form:option value="0" label="Select Region"/>
                                <form:options items="${region}"/>
                            </form:select>
                        </div>
                        <div class="form-group col-md-4">
                            <form:select id="districtInput" class="form-control" name="district" path="districtId">
                                <form:option value="0" label="Select District"/>
                                <form:options items="${district}"/>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <form:input type="text" class="form-control" id="postalCode" placeholder="Postal Code"
                                        path="postalCode"/>
                        </div>
                        <div class="form-group col-md-4">
                            <form:input type="text" class="form-control" id="phone" placeholder="Phone" path="phone"/>
                        </div>
                        <div class="form-group col-md-4">
                            <form:input type="email" class="form-control" id="email" placeholder="Email" path="email"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="reset" value="Reset">Cancel</button>
                        <input type="submit" class="btn btn-primary" value="Save"/>
                    </div>
                </form:form>
                <%--akhirform--%>
            </div>
        </div>
    </div>
</div>


</body>
<script>
    //edit
    function showEditValue(id) {
        window.alert(id);
        $.ajax({
            <%--            ${pageContext.request.contextPath}--%>
            url: "/outletJson/" + id,
            method: "get",
            dataType: "json",
            success:
                function (data) {
                    $('#id').val(data.id);
                    $('#name').val(data.name);
                    $('#address').val(data.address);
                    $('#province').val(data.provinceId);
                    $('#region').val(data.regionId);
                    $('#district').val(data.districtId);
                    $('#postalCode').val(data.postalCode);
                    $('#phone').val(data.phone);
                    $('#email').val(data.email);
                    // open modal
                    $('#editOutletModal').modal('show');
                },
        });
    }

    //dropdown
    window.onload = function () { // when the page has loaded
        document.getElementById("provinceInput").onchange = function () {
            var idProvince = $("#provinceInput").val();
            window.alert(idProvince)
            $.ajax({
                url: "/regionJson/" + idProvince,
                method: "get",
                dataType: "json",
                success:
                    function (data) {
                        var dropdown = $('#regionInput');
                        dropdown.empty();
                        dropdown.append('<option selected="true" disabled>-SELECT REGION-</option>');
                        dropdown.prop('selectedIndex', 0);
                        var dropdown2 = $('#districtInput');
                        dropdown2.empty();
                        dropdown2.append('<option selected="true" disabled>-SELECT DISTRICT-</option>');
                        dropdown2.prop('selectedIndex', 0);
                        data.forEach(function (entry) {
                            dropdown.append($('<option></option>').attr('value', entry.id).text(entry.name));
                        })
                    },
            });
        },
            document.getElementById("regionInput").onchange = function () {
                var idRegion = $("#regionInput").val();
                $.ajax({
                    url: "/districtJson/" + idRegion,
                    method: "get",
                    dataType: "json",
                    success:
                        function (data) {
                            var dropdown = $('#districtInput');
                            dropdown.empty();
                            dropdown.append('<option selected="true" disabled>-SELECT DISTRICT-</option>');
                            dropdown.prop('selectedIndex', 0);
                            data.forEach(function (entry) {
                                dropdown.append($('<option></option>').attr('value', entry.id).text(entry.name));
                            })
                        },
                });
            },
            document.getElementById("province").onchange = function () {
                var idProvince = $("#province").val();
                window.alert(idProvince)
                $.ajax({
                    url: "/regionJson/" + idProvince,
                    method: "get",
                    dataType: "json",
                    success:
                        function (data) {
                            var dropdown = $('#region');
                            dropdown.empty();
                            dropdown.append('<option selected="true" disabled>-SELECT REGION-</option>');
                            dropdown.prop('selectedIndex', 0);
                            var dropdown2 = $('#district');
                            dropdown2.empty();
                            dropdown2.append('<option selected="true" disabled>-SELECT DISTRICT-</option>');
                            dropdown2.prop('selectedIndex', 0);
                            data.forEach(function (entry) {
                                dropdown.append($('<option></option>').attr('value', entry.id).text(entry.name));
                            })
                        },
                });
            },
            document.getElementById("region").onchange = function () {
                var idRegion = $("#region").val();
                $.ajax({
                    url: "/districtJson/" + idRegion,
                    method: "get",
                    dataType: "json",
                    success:
                        function (data) {
                            var dropdown = $('#district');
                            dropdown.empty();
                            dropdown.append('<option selected="true" disabled>-SELECT DISTRICT-</option>');
                            dropdown.prop('selectedIndex', 0);
                            data.forEach(function (entry) {
                                dropdown.append($('<option></option>').attr('value', entry.id).text(entry.name));
                            })
                        },
                });
            }
    }

</script>

</html>
