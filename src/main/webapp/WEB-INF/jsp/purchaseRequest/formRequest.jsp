<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Add New Category</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />" rel="stylesheet"/>
</head> 
<body>
<div class="container">
    <%--    <h1>Category</h1>--%>
    <%--    <hr>--%>
    <form:form method="post" action="/saveCategory" commandName="category" class="form-horizontal">
        <div class="form-group">
                <%--            <label class="control-label col-md-3">Category Name</label>--%>
            <div class="col-md-7">
                <form:input type="text" class="form-control mx-sm-3" placeholder="Category Name" path="name" id="name"/>
                <form:errors path="name" cssStyle="color:#FF000" />
            </div>
        </div>
        <input type="submit" class="btn btn-primary float-right" value="Save"/>
        <button type="reset" class="btn btn-primary float-left" >Cancel</button>
        <%--        <button type="button" class="btn btn-primary" ONCLICK="location.href='/formCategory'">Cancel</button>--%>
    </form:form>
</div>
</body>
</html>
