<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Add User Page</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <h1>Add New User</h1>
    <hr>
    <form:form method="post" action="/save" class="form-horizontal" commandName="user">
        <div class="form-group">
            <label class="control-label col-md-3">Name</label>
            <div class="col-md-7">
                <form:input type="text" class="form-control" path="name"/>
                <form:errors path="name" cssStyle="color:#FF000" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">Age</label>
            <div class="col-md-7">
                <form:input type="text" class="form-control" path="age"/>
                <form:errors path="age" cssStyle="color:#FF000" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">Email</label>
            <div class="col-md-7">
                <form:input type="text" class="form-control" path="email"/>
                <form:errors path="email" cssStyle="color:#FF000" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">Username</label>
            <div class="col-md-7">
                <form:input type="text" class="form-control" path="username"/>
                <form:errors path="username" cssStyle="color:#FF000" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-md-3">Password</label>
            <div class="col-md-7">
                <form:input type="text" class="form-control" path="password"/>
                <form:errors path="password" cssStyle="color:#FF000" />
            </div>
        </div>

        <input type="submit" class="button" value="Save"/>
    </form:form>
</div>
</body>
</html>
