<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<head>
    <title>Supplier</title>
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
    <script>
        //search
        $(document).ready(function () {
            $("#any").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#supplier-table tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });

        //edit
        $(document).on('click', '.edit_data', function () {
            var idSupllier = $(this).attr("id");
            $.ajax({
                url: "/supplierJson/" + idSupllier,
                method: "GET",
                dataType: "json",
                success: function (data) {
                    $('#id').val(data.id);
                    $('#name').val(data.name);
                    $('#address').val(data.address);
                    $('#province').val(data.provinceId);
                    $('#region').val(data.regionId);
                    $('#district').val(data.districtId);
                    $('#postal_code').val(data.postalCode);
                    $('#phone').val(data.phone);
                    $('#email').val(data.email);
                }
            });
        });

        //add
        $(document).on('click', '.add_data', function () {
            $('#name').val("");
            $('#address').val("");
            $('#province').val(0);
            $('#region').val(0);
            $('#district').val(0);
            $('#postal_code').val("");
            $('#phone').val("");
            $('#email').val("");
        });

        //dropdown for region
        window.onload = function () { // when the page has loaded
            document.getElementById("province").onchange = function () {
                var idProvince = $("#province").val();
                window.alert(idProvince);
                $.ajax({
                    url: "/regionJson/" + idProvince,
                    method: "get",
                    dataType: "json",
                    success:
                        function (data) {
                            let dropdown = $('#region');
                            dropdown.empty();
                            dropdown.append('<option selected="true" disabled>-SELECT REGION-</option>');
                            dropdown.prop('selectedIndex', 0);

                            let dropdownD = $('#district');
                            dropdownD.empty();
                            dropdownD.append('<option selected="true" disabled>-SELECT DISTRICT-</option>');
                            dropdownD.prop('selectedIndex', 0);

                            data.forEach(function (entry) {
                                dropdown.append($('<option></option>').attr('value', entry.id).text(entry.name));
                            })
                        },
                });
            },
            document.getElementById("region").onchange = function () {
                var idRegion = $("#region").val();
                window.alert(idRegion);
                $.ajax({
                    url: "/districtJson/" + idRegion,
                    method: "get",
                    dataType: "json",
                    success:
                        function (data) {
                            let dropdown = $('#district');
                            dropdown.empty();
                            dropdown.append('<option selected="true" disabled>-SELECT DISTRICT-</option>');
                            dropdown.prop('selectedIndex', 0);
                            data.forEach(function (entry) {
                                dropdown.append($('<option></option>').attr('value', entry.id).text(entry.name));
                            })
                        },
                });
            },
            document.getElementById("district").onchange = function () {
                var idRegion = $("#district").val();
                window.alert(idRegion);
            }
        }



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
                <h4 class="m-0 text-white">User Name</h4>
                <p class="font-weight-light text-white mb-0">Role</p>
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
            <a href="/suppliers" class="nav-link text-white font-italic bg-secondary">
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
    <h2 class="display-4 text-dark">Supplier</h2>
    <div class="separator bg-dark"></div>
    <div class="row text-white">
        <div class="col">
            <div class="container text-center">
                <div class="container form-group text-left" style="margin-bottom: 10px">
                    <%--                    <form:form method="post" action="/search" class="form-horizontal float-left" commandName="search">--%>
                    <%--                        <form:input type="text" style="width: 300px" id="any" path="any"/>--%>
                    <%--                        <button type="submit" class="btn btn-primary">Search</button>--%>
                    <%--                    </form:form>--%>
                    <input type="text" style="width: 300px" id="any" placeholder="Search..."/>
                    <button id=null type="button" class="btn btn-primary float-right add_data" data-toggle="modal"
                            data-target="#ModalAdd">
                        Create
                    </button>
                </div>

                <br/>

                <div class="table-responsive">
                    <table class="table table-bordered text-dark">
                        <thead>
                        <tr>
                            <th width="80">Name</th>
                            <th width="120">Address</th>
                            <th width="120">Phone</th>
                            <th width="120">Email</th>
                            <th width="120">Province</th>
                            <th width="60">#</th>
                        </tr>
                        </thead>
                        <tbody id="supplier-table">
                        <c:forEach items="${suppliers}" var="supplier">
                            <tr>
                                <td>${supplier.name}</td>
                                <td>${supplier.address}</td>
                                <td>${supplier.phone}</td>
                                <td>${supplier.email}</td>
                                <td>${supplier.mstProvinces.name}</td>
                                <td>
                                        <%--                                    <a href="/supplierFormEdit/${supplier.id}">Edit</a>--%>
                                    <a href="#" name="edit" data-toggle="modal" id="${supplier.id}" class="edit_data"
                                       data-target="#ModalAdd">Edit</a>
                                    <a href="/deactivatedSupplier/${supplier.id}">Deactivated</a>
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

<!-- Modal Add -->
<div class="modal" id="ModalAdd">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Supplier</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <!-- Modal body -->
            <div class="modal-body">
                <jsp:include page="supplierForm.jsp"/>
            </div>
            <!-- Modal footer -->
            <%--            <div class="modal-footer">--%>
            <%--                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>--%>
            <%--            </div>--%>
        </div>
    </div>
</div>

</body>
