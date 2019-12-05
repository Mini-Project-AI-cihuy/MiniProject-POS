<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
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
</head>
<body>

<div class="container-fluid">
    <form:form method="post" action="/updateItemInventory" class="form-horizontal">
    <div class="form-group">
       <div class="row">
            <div class="form-group">
                <label class="control-label col-md-12">Variant Name</label>
                <div class="col-md-12">
                    <input name="variantName" id="variantName" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-6">Unit Price</label>
                <div class="col-md-12">
                    <input name="unitPrice" id="unitPrice" type="text" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-6">SKU</label>
                <div class="col-md-12">
                    <input name="sku" id="sku" type="text" class="form-control"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label class="control-label col-md-12">Beginning Stock</label>
                <div class="col-md-12">
                    <input name ="beginning" id="beginning" type="text" class="form-control" name="beginning"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-6">Alert At</label>
                <div class="col-md-12">
                    <input name="alertAt" id="alertAt" type="text" class="form-control" name="alertAt"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col text-right">
                <input type="reset" class="btn btn-primary" value="Cancel"/>
                <input type="submit" class="btn btn-primary" value="Save"/>
            </div>
        </div>
        </form:form>
    </div>
</body>
</html>
