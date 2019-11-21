<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Edit User Page</title>
    <link type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"/>
</head>
<body>
<h1>Edit User</h1>
<form:form method="post" action="/editSave" commandName="user" class="form-horizontal">
    <form:hidden path="id"/>
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
    <input type="submit" class="button" value="Edit"/>
</form:form>

</body>
</html>