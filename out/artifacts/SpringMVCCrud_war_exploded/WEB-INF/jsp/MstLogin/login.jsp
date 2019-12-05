<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Login</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link type="text/css" href="<c:url value='/resources/css/login.css' />" rel="stylesheet"/>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->
        <div class="fadeIn first">
        </div>
        <br>
        <h1 class="display-4 text-dark">Log In</h1>
        <br>
        <!-- Login Form -->
        <form style="margin-top: 10px" name="loginForm" action="<c:url value='/login'/>" method="POST">
            <input type="text" class="fadeIn second" name="username" value='' placeholder="Username">
            <input id="password" type="password" class="fadeIn third" name="password" placeholder="Password">
            <!-- invalid credentials error msg -->
            <br>
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <!-- logged out msg -->
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>
            <br>
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>
        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="/resetPassword">Forgot Password?</a>
        </div>

    </div>
</div>

<!-- custom login form -->
<%--<form name="loginform" action="<c:url value='/login'/>" method="POST">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>Enter username:</td>--%>
<%--            <td><input type='text' name='username' value=''></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Enter password:</td>--%>
<%--            <td><input type='password' name='password' /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td colspan="2"> </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td colspan='2'><input name="submit" type="submit" value="Submit" /></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>
</body>
</html>
