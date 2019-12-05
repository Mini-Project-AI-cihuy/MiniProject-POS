<%--
  Created by IntelliJ IDEA.
  User: falih farhan
  Date: 04/12/2019
  Time: 18.38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Purchase Request</title>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>
    <script>
        //refresh
        function refreshPage() {
            window.location.reload();
        }

        //search
        $(document).ready(function () {
            $("#any").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#listRequest-table tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });

    </script>
    <script>
        //set databale based drowpdown status
        function setDataTable() {
            var statusC = $("#status").val();
            if (statusC == 'refresh') {
                refreshPage();
            }
            $.ajax({
                url: "/requestJson/" + statusC,
                method: "get",
                dataType: "json",
                success:
                    function (data) {
                        let table = $('#listRequest-table');
                        table.empty();
                        data.forEach(function (data) {

                            table.append($('<td></td>').text(formatDate(data.createdOn)));
                            table.append($('<td></td>').text(data.prNo));
                            table.append($('<td></td>').text(data.notes));
                            table.append($('<td></td>').text(data.status));
                            table.append($('<td>\n' +
                                '                                    <div class="btn-group" role="group" aria-label="Basic example">\n' +
                                '                                        <button type="button" class="btn btn-link">Edit</button>\n' +
                                '                                        <button type="button" class="btn btn-link">View</button>\n' +
                                '                                    </div>\n' +
                                '                                </td>'));
                            table.append($('<tr></tr>'));
                        })
                    },
            });
        };

        //format date
        function formatDate(date) {
            var today = new Date(date);
            var dd = today.getDate();
            var mm = today.getMonth() + 1; //January is 0!
            var yyyy = today.getFullYear();
            if (dd < 10) {
                dd = '0' + dd;
            }
            if (mm < 10) {
                mm = '0' + mm;
            }
            var today = dd + '/' + mm + '/' + yyyy;
            return today;
        }

        // date picker
        $(function () {
            $('input[name="daterange"]').daterangepicker({
                opens: 'left',
                locale: {
                    format: 'DD/MM/YYYY'
                }
            }, function (start, end, label) {
                console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
            });
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

<sec:authorize access="hasAuthority('Back Office') and isAuthenticated()">
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
            <a href="/listRequest" class="nav-link text-white font-italic bg-secondary">
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

<!-- Page content holder -->
<div class="page-content p-5 bg-white" id="content">
    <!-- Toggle button -->
    <%--    <button id="sidebarCollapse" type="button" class="btn btn-light bg-white rounded-pill shadow-sm px-4 mb-4"><i class="fa fa-bars mr-2"></i><small class="text-uppercase font-weight-bold">Toggle</small></button>--%>

    <!-- Demo content -->
    <h2 class="display-4 text-dark">Purchase Request</h2>
    <div class="separator bg-dark"></div>
    <div class="row text-white">
        <div class="col">
            <div class="container text-center">
                <form>
                    <div class="row">
                        <div class="col-3">
                            <input type="text" class="form-control" name="daterange"/>
                        </div>
                        <div class="col-2">
                            <select class="form-control dropdown w-100" id="status" name="status"
                                    onchange="setDataTable()">
                                <option value="refresh" selected="selected">Select Status</option>
                                <option value="Created">Created</option>
                                <option value="Approve">Approve</option>
                                <option value="Reject">Reject</option>
                                <option value="Print">Print</option>
                                <option value="Create PO">Create PO</option>
                            </select>
                        </div>
                        <input class="form-control w-100 col-4" type="text" id="any" placeholder="Search..."/>
                        <div class="col-2 text-right">
                            <button type="button" class="btn btn-primary">
                                Export
                            </button>
                            <button type="button" class="btn btn-primary add_data" data-toggle="modal"
                                    data-target="#modalRequest">
                                Create
                            </button>
                        </div>
                    </div>
                </form>
                <br>
                <div class="table-responsive">
                    <table id="PO-table" class="table table-bordered text-dark">
                        <thead>
                        <tr>
                            <th width="120">Create Date</th>
                            <th width="120">PR No.</th>
                            <th width="120">Note</th>
                            <th width="120">Status</th>
                            <th width="60">#</th>
                        </tr>
                        </thead>
                        <tbody id="listRequest-table">
                        <c:forEach items="${listRequest}" var="request">
                            <tr>
                                <td>
                                    <fmt:formatDate type="date" pattern="dd/MM/YYYY"
                                                    value="${request.createdOn}"/>
                                </td>
                                <td>${request.prNo}</td>
                                <td>${request.notes}</td>
                                <td>${request.status}</td>
                                <td>
                                    <div class="btn-group" role="group" aria-label="Basic example">
                                        <button id="${request.id}" type="button" class="btn btn-link edit_data" data-toggle="modal"
                                                data-target="#modalRequest">Edit</button>
                                        <button type="button" class="btn btn-link" >View</button>
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
</body>

<div class="modal fade" id="modalRequest">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Purchase Request</h5>
                <hr>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <jsp:include page="formRequest.jsp"/>
            </div>
        </div>
    </div>
</div>
<script>
    //add
    $(document).on('click', '.add_data', function () {
        $('#id').val("");
        $('#notes').val("");
        $('#readytime').val("");
    });

    //edit
    $(document).on('click', '.edit_data', function () {
        var id = $(this).attr("id");
        $.ajax({
            url: "/requestJsonById/" + id,
            method: "GET",
            dataType: "json",
            success: function (data) {
                $('#id').val(data.id);
                $('#readytime').val(formatDate(data.readyTime));
                $('#notes').val(data.notes);
            }
        });
        $.ajax({
            url: "/requestDetailJsonByPrId/" + id,
            method: "get",
            dataType: "json",
            success:
                function (data) {
                    let table = $('#request-variant-table');
                    table.empty();
                    data.forEach(function (data) {
                        table.append($('<td></td>').text(data.mstItemVariant.mstItem.name+" - "+ data.mstItemVariant.name));
                        table.append($('<td></td>').text(data.requestQty));
                        table.append($('<td></td>').text(data.requestQty));
                        table.append($('<tr></tr>'));
                    })
                },
        });
    });

</script>

</html>
