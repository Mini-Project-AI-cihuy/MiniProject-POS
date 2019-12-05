<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Page</title>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-grid.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-reboot.css' />" rel="stylesheet"/>
    <link type="text/css" href="<c:url value='/resources/css/homepage.css' />" rel="stylesheet"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<!-- Navbar -->
<div class="vertical-nav bg-dark" id="sidebar">
    <div class="py-4 px-3 mb-4 bg-dark">
        <div class="media d-flex align-items-center">
            <img src="https://res.cloudinary.com/mhmd/image/upload/v1556074849/avatar-1_tcnd60.png"
                 alt="..." width="65"
                 class="mr-3 rounded-circle img-thumbnail shadow-sm">
            <div class="media-body">
                <h4 class="m-0 text-white">User Name</h4>
                <p class="font-weight-light text-white mb-0">Role</p>
            </div>
        </div>
    </div>

    <p class="text-white font-weight-bold text-uppercase px-3 small pb-4 mb-0">Main</p>

    <ul class="nav flex-column bg-dark mb-0">
        <li class="nav-item">
            <a href="/listUser" class="nav-link text-white font-italic bg-secondary">
                <i class="fa fa-id-card-o mr-3 text-primary fa-fw"></i>
                Employee
            </a>
        </li>
        <li class="nav-item">
            <a href="MiniProject_POS_war/categories" class="nav-link text-white font-italic">
                <i class="fa fa-th-large mr-3 text-primary fa-fw"></i>
                Category
            </a>
        </li>
        <li class="nav-item">
            <a href="MiniProject_POS_war/suppliers" class="nav-link text-white font-italic">
                <i class="fa fa-truck mr-3 text-primary fa-fw"></i>
                Supplier
            </a>
        </li>
        <li class="nav-item">
            <a href="MiniProject_POS_war/outlets" class="nav-link text-white font-italic ">
                <i class="fa fa-shopping-bag mr-3 text-primary fa-fw"></i>
                Outlet
            </a>
        </li>
        <li class="nav-item">
            <a href="MiniProject_POS_war/items" class="nav-link text-white font-italic">
                <i class="fa fa-cubes mr-3 text-primary fa-fw"></i>
                Item
            </a>
        </li>
    </ul>
</div>
<!-- End vertical navbar -->
<div class="page-content p-5 bg-white" id="content">
    <h2 class="display-4 text-dark">Employee</h2>
    <div class="separator bg-dark"></div>
    <form:form action="/saveUser" method="post" modelAttribute="employee">
        <div class="row text-white">
            <div class="col">
                <div class="container text-center">
                    <fieldset id="main">
                        <div class="form-row">
                            <input type="hidden" class="form-control" name="id" id="id" placeholder="id">
                            <div class="form-group col-md-3">
                                <label for="firstName">First Name</label>
                                <input type="text" class="form-control" id="firstName" name="firstName"
                                       placeholder="First Name">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="lastName">Last Name</label>
                                <input type="text" class="form-control" id="lastName" name="lastName"
                                       placeholder="Last Name">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                            </div>
                            <div class="form-group col-md-2">
                                <label for="email">title</label>
                                <select class="custom-select my-1 mr-sm-2" name="title"
                                        id="inlineFormCustomSelectPref2">
                                    <option selected>Choose...</option>
                                    <option value="Mr">Mr</option>
                                    <option value="Mrs.">Mrs</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <form:select class="custom-select" id="outletId"
                                             path="employeeOutlet.outletId">
                                    <form:option value="0" label="-SELECT OUTLET-"/>
                                    <form:options items="${outlets}"/>
                                </form:select>
                            </div>
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" name="checkbox" class="custom-control-input" id="showSecondary"
                                       onclick="showSubMenu()">
                                <label class="custom-control-label" for="showSecondary" style="color: #1b1e21">Create
                                    New Account?</label>
                            </div>
                        </div>
                    </fieldset>
                    <br/>
                    <hr>
                    <br>
                    <fieldset id="secondary" style="display: none">
                        <div class="form-row">
                            <div class="col-md-3 mb-3">
                                <form:select class="custom-select" id="role" path="mstUser.roleId">
                                    <form:option value="0" label="-SELECT ROLE-"/>
                                    <form:options items="${roles}"/>
                                </form:select>
                            </div>
                            <div class="col-md-3 mb-3">
                                <input type="text" class="form-control" id="username" placeholder="Username"
                                       name="username"
                                       aria-describedby="inputGroupPrepend">
                            </div>
                            <div class="col-md-3 mb-3">
                                    <%--                            <label for="password">Password</label>--%>
                                <input type="password" class="form-control" id="password" placeholder="Password"
                                       name="password"
                                       aria-describedby="inputGroupPrepend">
                                <div class="valid-feedback">
                                </div>
                            </div>
                        </div>
                    </fieldset>
                    <fieldset id="save">
                        <button class="btn btn-primary btn-lg pull-right" style="margin-left: 30px" type="save"
                                value="save">
                            Save
                        </button>
                        <button class="btn btn-primary btn-lg pull-right" type="reset" value="reset">
                            Cancel
                        </button>
                    </fieldset>
                    <br/>
                    <br/>
                    <!-- Tabel Outlet -->
                    <div>
                        <table class="table">
                            <thead>
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Have Account?</th>
                                <th scope="col">Outlet Access</th>
                                <th scope="col">Role</th>
                                <th scope="col" colspan="2">#</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${employees}" var="employee">
                                <tr>
                                    <td>${employee.firstName} ${employee.lastName}</td>
                                    <td>${employee.email}</td>
                                    <td>${employee.haveAccount}</td>
                                    <td>${employee.employeeOutlet.mstOutlet.name}</td>
                                    <td>${employee.mstUser.mstRole.name}</td>
                                    <td><a href="/edit?id=${employee.id}" name="edit" class="edit">
                                        <i class="fa fa-pencil col-1"></i>
                                    </a>
                                        <a href="/delete?id=${employee.id}" name="delete" class="delete">
                                            <i class="fa fa-trash col-1"></i>
                                        </a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>


<script>
    function showSubMenu() {
        if (document.getElementById('showSecondary').checked) {
            document.getElementById('secondary').style.display = 'block';
        } else {
            document.getElementById('secondary').style.display = 'none';
        }
    }
</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>