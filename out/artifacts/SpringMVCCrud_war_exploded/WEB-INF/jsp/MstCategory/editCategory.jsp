<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Edit Category</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-grid.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-reboot.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/css/homepage.css' />" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.bundle.js'/>"></script>
    <script src="<c:url value='/resources/bootstrap/js/bootstrap.js'/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <%--    <h1>Category</h1>--%>
    <%--    <hr>--%>
        <form:form method="post" action="/saveCategory" commandName="category" class="form-horizontal">
            <form:hidden path="id" id="id"/>
            <div class="form-group">
                    <%--        <label class="control-label col-md-3">Category Name</label>--%>
                <form:input type="text" class="form-control" path="name" id="name"/>
                <form:errors path="name" cssStyle="color:#FF000"/>
            </div>
            <input type="submit" class="btn btn-primary float-right" value="Save"/>
            <input type="reset" class="btn btn-primary float-right" style="margin-right: 10px" value="Cancel">
        </form:form>

        <form:form method="post" action="/deactivateCategory" commandName="categoryD" class="form-horizontal">
            <form:hidden path="id" id="idC"/>
            <sec:authorize access="hasAuthority('Administrator') and isAuthenticated()">
                <input type="submit" class="btn btn-danger float-left" value="X">
            </sec:authorize>
        </form:form>
</div>
</body>
</html>