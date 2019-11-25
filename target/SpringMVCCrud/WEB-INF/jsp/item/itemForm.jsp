<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <%--    <link type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"/>--%>
</head>
<body>

<div class="container-fluid">
    <form:form method="post" action="/save" class="form-horizontal" commandName="supplier">
        <div class="form-group">
            <label class="control-label col-md-6">Supplier Name</label>
            <div class="col-md-12">
                <form:input type="text" class="form-control" path="name"/>
                    <%--                <form:errors path="name" cssStyle="color:#FF000" />--%>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-6">Address</label>
            <div class="col-md-12">
                <form:textarea type="text" class="form-control" path="address"/>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label class="control-label col-md-6">Province</label>
                <div class="col-md-12">
                    <form:select path="provinceId" class="form-control">
                        <form:option value="0" label="-SELECT PROVINCE-"/>
                        <form:options items="${province}"/>
                    </form:select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-6">Region</label>
                <div class="col-md-12">
                    <form:select path="regionId" class="form-control">
                        <form:option value="0" label="-SELECT REGION-"/>
                        <form:options items="${region}"/>
                    </form:select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-6">District</label>
                <div class="col-md-12">
                    <form:select path="districtId" class="form-control">
                        <form:option value="0" label="-SELECT DISTRICT-"/>
                        <form:options items="${district}"/>
                    </form:select>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label class="control-label col-md-6">Postal Code</label>
                <div class="col-md-12">
                    <form:input type="text" class="form-control" path="postalCode"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-6">Phone</label>
                <div class="col-md-12">
                    <form:input type="text" class="form-control" path="phone"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-6">Email</label>
                <div class="col-md-12">
                    <form:input type="text" class="form-control" path="email"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col text-right">
                <input type="reset" class="btn btn-danger" value="Cancel"/>
                <input type="submit" class="btn btn-primary" value="Save"/>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
