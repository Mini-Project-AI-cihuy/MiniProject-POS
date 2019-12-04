<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Reset Password</title>
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
        <a class="display-4 text-dark">Reset</a>
        <br>
        <a class="display-4 text-dark">Password</a>
        <br>
        <!-- Form -->
        <form:form style="margin-top: 10px" name="loginForm" action="/resetPassword" method="POST">
            <input path="email" id="email" type="text" class="fadeIn second" name="email" placeholder="Email"/>
            <input path="password" id="password" type="password" class="fadeIn third" name="password" placeholder="New Password"/>
            <input path="rePassword" id="repassword" type="password" class="fadeIn third" name="repassword" placeholder="Retype Password"/>
            <!-- invalid credentials error msg -->
            <br>
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty errorMatch}">
                <div class="error">${errorMatch}</div>
            </c:if>
            <br>
            <input class="submit" type="submit" class="fadeIn fourth" value="Submit">
        </form:form>
        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="/login">Back to Log In</a>
        </div>

    </div>
</div>
</body>
</html>
