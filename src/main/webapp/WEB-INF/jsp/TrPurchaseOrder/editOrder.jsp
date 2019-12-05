<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Purchase Order</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />" rel="stylesheet"/>

</head>
<body>
<div class="container">
    <form:form method="post" action="/saveCategory" commandName="editOrder" class="form-horizontal">
    <div class="form-group">
            <%--            <label class="control-label col-md-3">Category Name</label>--%>
        <div class="col-md-12">
            <form:hidden path="outletId" value="${outlet.id}"></form:hidden>
            <Label>EDIT NEW PO : ${outlet.name}</Label>
            <div class="separator bg-dark" style="margin-top: 10px"></div>
        </div>
        <div class="col-md-12">
            <div class="form-group">
                <div class="col-md-12">
                    <form:select id="supplier" path="mstSupplier.id" class="form-control">
                        <form:option value="0" label="Choose Supplier"/>
                        <form:options items="${supplier}"/>
                    </form:select>
                </div>
            </div>
        </div>
        <br>
        <div class="col-md-12">
            <label for="notes">Notes</label>
            <form:textarea type="text" class="form-control" id="notes" path="notes"/>
        </div>
        <br>
        <div class="col-md-12">
            <Label>Purchase Order</Label>
            <div class="separator bg-dark" style="margin-top: 10px; margin-bottom: 10px"></div>
            <table id="listOrder-header" class="table table-bordered text-dark">
                <thead>
                <tr>
                    <th hidden>Id</th>
                    <th>Item</th>
                    <th>In Stock</th>
                    <th>Qty</th>
                    <th>Unit Cost</th>
                    <th>Sub Total</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="orderD" items="${orderDetail}">
                    <tr>
                        <td hidden>${orderD.inventory.variant.item.id}</td>
                        <td hidden>${orderD.po_id}</td>
                        <td>${orderD.inventory.variant.item.name} - ${orderD.inventory.variant.name}</td>
                        <td disabled="true">${orderD.inventory.adjustmentQty}</td>
                        <td disabled="true">${orderD.inventory.adjustmentQty}</td>
                        <td>
                                <%--                                                            <form:form method="POST" action="/PurchaseOrder/update-po" modelAttribute="PODetail">--%>
                                <%--                                                                <form:input id="unitCost" path="unit_cost"/>--%>
                            <input style="background: transparent; border: none; color: white;" class="form-control"
                                   id="unitCost" value="${orderD.unit_cost}"/>

                                <%--                                                                <button type="submit" class="btn btn-success">O</button>--%>
                                <%--                                                            </form:form>--%>
                        </td>
                        <td disabled="true">
                            <fmt:formatNumber type="currency" currencySymbol="Rp." value = "${orderD.sub_total}" />
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <br>
        <input type="submit" class="btn btn-primary float-right" value="Save"/>
        <input type="reset" class="btn btn-primary float-right" style="margin-right: 10px" value="Cancel">
        <input type="submit" class="btn btn-success float-right" style="margin-right: 10px" value="Submit">
        </form:form>
    </div>
</body>
</html>