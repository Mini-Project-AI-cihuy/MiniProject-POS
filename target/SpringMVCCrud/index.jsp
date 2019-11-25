<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Welcome Page</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <h1>Welcome User!</h1>
    <br>
    <button type="button" class="button" ONCLICK="location.href='/userForm'">Add</button>
    <button type="button" class="button" ONCLICK="location.href='/listCategory'">View</button>
</div>
</body>
</html>