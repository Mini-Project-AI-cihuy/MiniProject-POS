<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List Order</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-grid.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-reboot.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/css/homepage.css' />" rel="stylesheet"/>
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.bundle.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.js'/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
    <script src="https://cdn.datatables.net/fixedheader/3.1.2/js/dataTables.fixedHeader.min.js"></script>
    <script>
        //search
        $(document).ready(function () {
            $("#any").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#listOrder-table tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });

        //date range
        $(function() {
            $('input[name="dateRange"]').daterangepicker({
                locale: {
                    format: 'DD/MM/YYYY'
                }
            });
        });
        //date filter
    </script>
</head>
<body>
<jsp:useBean id="date" class="java.util.Date"/>
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
            <a href="/items" class="nav-link text-white font-italic">
                <i class="fa fa-cubes mr-3 text-primary fa-fw"></i>
                Items
            </a>
        </li>
    </ul>
    <br>
    <p class="text-white font-weight-bold text-uppercase px-3 small pb-4 mb-0">Transaction</p>

    <ul class="nav flex-column bg-dark mb-0">
        <li class="nav-item">
            <a href="/listRequest" class="nav-link text-white font-italic">
                <i class="fa fa-id-card-o mr-3 text-primary fa-fw"></i>
                Purchase Request
            </a>
        </li>
        <li class="nav-item">
            <a href="/listOrder" class="nav-link text-white font-italic bg-secondary">
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
</div>
<!-- End vertical navbar -->

<!-- Page content holder -->
<div class="page-content p-5 bg-white" id="content">
    <!-- Toggle button -->
    <%--    <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4"><i class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Toggle</small></button>--%>

    <!-- Demo content -->
    <h2 class="display-4 text-dark">Purchase Order</h2>
    <div class="separator bg-dark"></div>
    <div class="row text-white">
        <div class="col">
            <div class="container text-center">
                <form>
                    <div class="row">
                        <div class="col-4">
                            <input type="text" class="form-control" name="dateRange" />
                        </div>
                        <div class="col-3">
                            <select class="form-control dropdown w-100" id="status" name="status">
                                <option value="" selected="selected" disabled="disabled">-- Select Status --</option>
                                <option value="Approve">Approve</option>
                                <option value="Reject">Reject</option>
                                <option value="Process">Process</option>
                                <option value="Print">Print</option>
                            </select>
                        </div>
                        <div class="col-3">
                            <input class="form-control w-100" type="text" id="any" placeholder="Search..."/>
                        </div>
                        <div class="col-2 text-right">
                            <button id="exportButton" type="button" class="btn btn-primary">
                                Export
                            </button>
                        </div>
                    </div>
                </form>
                <br>
                <div class="table-responsive">
                    <table id="listOrder-header" class="table table-bordered text-dark">
                        <thead>
                        <tr>
                            <th width="120">Create Date</th>
                            <th width="120">Supplier</th>
                            <th width="120">PO No.</th>
                            <th width="120">Total</th>
                            <th width="120">Status</th>
                            <th width="60">#</th>
                        </tr>
                        </thead>
                        <tbody id="listOrder-table">
                        <c:forEach items="${listOrder}" var="order">
                            <tr>
                                <td><fmt:formatDate value="${order.createdOn}" type="date" pattern="dd/MM/YYYY"/></td>
                                <td>${order.mstSupplier.name}</td>
                                <td>${order.poNo}</td>
                                <td><fmt:formatNumber type="currency" currencySymbol="Rp.">${order.grandTotal}</fmt:formatNumber></td>
                                <td>${order.status}</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button id="${order.id}" type="button" class="btn btn-link edit_data" data-toggle="modal"
                                                data-target="#modalEditPO">
                                            Edit
                                        </button>
                                        <button type="button" class="btn btn-link">View</button>
                                    </div>
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

<div class="modal fade" id="modalEditPO">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Purchase Order</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <jsp:include page="editOrder.jsp"/>
            </div>
            <%--            <div class="modal-footer">--%>
            <%--                <button type="button" class="btn btn-primary">Save changes</button>--%>
            <%--                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
            <%--            </div>--%>
        </div>
    </div>
</div>
</body>
<script>
    $(document).on('click', '.edit_data', function() {
        var poId = $(this).attr("id");
        window.alert("Hello, " + poId);
        $.ajax({
            url: "orderJson/" + poId,
            method: "GET",
            dataType: "json",
            success: function (data) {
                $('#id').val(data.id);
                $('#poNo').val(data.poNo);
                $('#status').val(data.status);
                $('#grandTotal').val(data.grandTotal);
                $('#outletId').val(data.outlet_id);
                $('#supplier').val(data.mstSupplier.id);
                $('#notes').val(data.notes);
            }
        })
    });
</script>
</html>