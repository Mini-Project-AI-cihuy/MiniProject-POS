<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Add New Items</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />" rel="stylesheet"/>
    <script>
        //hide modal
        // $(".hide-modal").click(function(){
        //     $("#modalVariant").modal('hide');
        // });
        // $('#modalVariant').on('click', '.modal .close', function () {
        //     $(this).closest('.modal').modal('hide');
        // });
    </script>
</head>
<body>
<div class="container-fluid">
    <form:form method="post" action="/updateSupplier" class="form-horizontal" commandName="itemInventory">
    <div class="form-group">
        <form:hidden path="mstItemVariant.mstItem.id" id="itemId"/>
        <div class="col-md-12">
            <form:input type="text" class="form-control" path="mstItemVariant.mstItem.name" id="name" placeholder="Item Name"/>
                <%--                <form:errors path="name" cssStyle="color:#FF000" />--%>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-12">
            <form:select id="category" path="mstItemVariant.mstItem.mstCategory.id" class="form-control">
                <form:option value="0" label="Choose Category"/>
                <form:options items="${category}"/>
            </form:select>
        </div>
    </div>

    <div class="form-group">
        <div class="col">
            <div class="container text-center">
                <div class="container form-group text-left" style="margin-bottom: 10px">
                    <h5 class="float-left">VARIANT</h5>
                    <button type="button" class="btn btn-primary float-right" data-toggle="modal"
                            data-target="#modalVariant">
                        Add Variant
                    </button>
                </div>
            </div>
            <br>
            <br>
            <div class="table-responsive">
                <table class="table table-bordered text-dark">
                    <thead>
                    <tr>
                        <th width="180">Variant Name</th>
                        <th width="120">Unit Price</th>
                        <th width="120">SKU</th>
                        <th width="120">Beginning</th>
                        <th width="60">#</th>
                    </tr>
                    </thead>
                    <tbody id="category-table">
                    <c:forEach items="${mstItemVariant}" var="variant">
                        <tr>
                            <td>${variant.name}</td>
                            <td>${variant.price}</td>
                            <td>${variant.sku}</td>
                            <td>??</td>
                            <td>
<%--                                <button type="button" class="btn btn-link" data-toggle="modal" data-target="#modalEditCategory">View</button>--%>
<%--                                <button type="button" class="btn btn-link" ONCLICK="location.href='/editCategory/${category.id}'">--%>
<%--                                    Edit--%>
<%--                                </button>--%>
                                    <button type="button" class="btn btn-link edit_data" id="${mstItemVariant.id}" data-toggle="modal" data-target="#modalVariant">
                                        Edit
                                    </button>
                                    <input type="submit" class="btn btn-danger float-left" value="X">
<%--                                <a href="/editCategory/${category.id}">View</a>--%>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="row">
                <input type="reset" class="btn btn-primary float-left" value="Back"/>
                <div class="col text-center">
                    <input type="reset" class="btn btn-primary float" value="Cancel"/>
                </div>
                <input type="submit" class="btn btn-primary float-right" value="Save"/>
            </div>
            </form:form>
        </div>
    </div>
</div>
<!-- Modal Add -->
<div class="modal fade" id="modalVariant">
    <div class="modal-dialog modal-dialog-centered modal-lg modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add Variant</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <jsp:include page="itemVariantForm.jsp"/>
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
