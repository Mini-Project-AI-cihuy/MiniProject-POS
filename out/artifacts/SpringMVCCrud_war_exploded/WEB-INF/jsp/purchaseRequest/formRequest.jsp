<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Purchase Request</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />" rel="stylesheet"/>

    <script>
        //date range
        function filterRows() {
            var from = $('#dateFilterFrom').val();
            var to = $('#dateFilterTo').val();

            if (!from && !to) { // no value for from and to
                return;
            }

            from = from || '1970-01-01'; // default from to a old date if it is not set
            to = to || '2999-12-31';

            var dateFrom = moment(from);
            var dateTo = moment(to);

            $('#PO-table tr').each(function (i, tr) {
                var val = $(tr).find("td:nth-child(1)").text();
                var dateVal = moment(val, "MM/DD/YYYY");
                var visible = (dateVal.isBetween(dateFrom, dateTo, null, [])) ? "" : "none"; // [] for inclusive
                $(tr).css('display', visible);
            });
        }
        $('#dateFilter').on("change", filterRows);
    </script>
</head>
<body>
<div class="container">
    <form:form method="post" action="/saveCategory" commandName="request" class="form-horizontal">
    <div class="form-group">
            <%--            <label class="control-label col-md-3">Category Name</label>--%>
        <div class="col-md-12">
            <form:hidden id="id" path="id"></form:hidden>
            <form:hidden path="outletId" value="${outlet.id}"></form:hidden>
            <Label>CREATE NEW PR : ${outlet.name}</Label>
            <div class="separator bg-dark" style="margin-top: 10px"></div>
        </div>
        <div class="col-md-12">
            <form:input path="readyTime" id="readytime" type="date" class="form-control"/>
        </div>
        <br>
        <div class="col-md-12">
            <form:textarea path="notes" type="text" class="form-control textarea" id="notes"
                           placeholder="notes"/>
        </div>
        <br>
        <div class="col-md-12">
            <Label>Purchase Request</Label>
            <div class="separator bg-dark" style="margin-top: 10px; margin-bottom: 10px">
            </div>
            <button class="col-md-12 btn btn-primary">Add Item
            </button>
        </div>
                <br>
        <div class="table-responsive">
            <table class="table table-bordered text-dark">
                <thead>
                <tr>
                    <th width="180">item</th>
                    <th width="120">In Stock</th>
                    <th width="120">Request QTY</th>
                </tr>
                </thead>
                <tbody id="request-variant-table">
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>
                            <input type="submit" class="btn btn-danger float-left" value="X">
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <br>
        <input type="submit" class="btn btn-primary float-right" value="Save"/>
        <input type="reset" class="btn btn-primary float-left" value="cancel">
        </form:form>

</body>

<div class="modal fade" id="modalAddItem">
    <div class="modal-dialog modal-dialog-centered modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Purchase Request</h5>
                <hr>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                </div>
            </div>
        </div>
    </div>
</div>


</html>
