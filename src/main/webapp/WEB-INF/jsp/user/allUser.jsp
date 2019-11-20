<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<head>
    <title>User Page</title>
    <link type="text/css" href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"/>
</head>

<h1>Users List</h1>

<hr>

<%--<div class="container form-group text-left" style="margin-bottom: 10px">--%>
<%--    <form method="post" action="/search" class="form-horizontal">--%>
<%--        <input type="text" style="width: 500px" id="param"/>--%>
<%--        <button type="button" class="button" ONCLICK="href='/search'">Search</button>--%>
<%--    </form>--%>
<%--</div>--%>

<div class="container text-center">
    <br/>
    <div class="table-responsive">
        <table class="table table-bordered">
            <tr>
                <th width="80">User ID</th>
                <th width="120">User Name</th>
                <th width="120">User Age</th>
                <th width="120">User Email</th>
                <th width="120">User Username</th>
                <th width="120">User Password</th>
                <th width="60">Action</th>
            </tr>
            <c:forEach items="${allUser}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.email}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>
                        <a href="/editUser/${user.id}"><span class="glyphicon glyphicon-edit"></span></a>
                        <a href="/deleteUser/${user.id}"><span class="glyphicon glyphicon-trash"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<button type="button" class="button" ONCLICK="location.href='/userForm'"><span class="glyphicon glyphicon-plus-sign"></span></button>
<script src="static/js/jquery-1.11.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>