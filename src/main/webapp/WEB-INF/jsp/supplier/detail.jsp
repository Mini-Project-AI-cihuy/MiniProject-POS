<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Detail User Page</title>
<%--    <link type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"/>--%>
</head>
<body>

<div class="container text-center">
<h1>Users Detail</h1>
    <hr>
    <div class="table-responsive">
    <table class="table table-bordered">
        <tr>
            <th width="80">Name</th>
            <th width="120">Address</th>
            <th width="120">Phone</th>
            <th width="120">Email</th>
            <th width="120">Region</th>
        </tr>
            <tr>
                <td>${supplier.name}</td>
                <td>${supplier.address}</td>
                <td>${supplier.phone}</td>
                <td>${supplier.email}</td>
                <td>${supplier.mstRegion.name}</td>
            </tr>
    </table>
    </div>
</div>
</body>
</html>