<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%--
  Created by IntelliJ IDEA.
  User: ChandraYA
  Date: 25/11/2019
  Time: 16.35
  To change this template use File | Settings | File Templates.
--%>
<form:form method="POST" action="/editOutlet" class="form-horizontal" modelAttribute="edit">
    <form:input type="hidden" class="form-control" path="id"/>
    <div class="form-group">
        <label for="name" class="col-form-label">Outlet Name</label>
        <form:input type="text" class="form-control" path="name"/>
    </div>
    <div class="form-group">
        <label for="address" class="col-form-label">Address</label>
        <form:textarea class="form-control" id="address" path="address"/>
    </div>
    <div class="form-row">
        <div class="form-group col-md-4">
            <form:select id="province" class="form-control" name="Province" path="provinceId">
                <form:option value="0" label="Select Province"/>
                <form:options items="${province}"/>
            </form:select>
        </div>
        <div class="form-group col-md-4">
            <form:select id="region" class="form-control" name="Region" path="regionId">
                <form:option value="0" label="Select Region"/>
                <form:options items="${region}"/>
            </form:select>
        </div>
        <div class="form-group col-md-4">
            <form:select id="district" class="form-control" name="District" path="districtId">
                <form:option value="0" label="Select District"/>
                <form:options items="${district}"/>
            </form:select>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-4">
            <form:input type="text" class="form-control" id="postalCode" placeholder="Postal Code"
                        path="postalCode"/>
        </div>
        <div class="form-group col-md-4">
            <form:input type="text" class="form-control" id="phone" placeholder="Phone" path="phone"/>
        </div>
        <div class="form-group col-md-4">
            <form:input type="email" class="form-control" id="email" placeholder="Email" path="email"/>
        </div>
    </div>
    <div class="modal-footer">
        <button class="btn btn-secondary" type="reset" value="Reset">Cancel</button>
        <input type="submit" class="btn btn-primary" value="Save"/>
    </div>
</form:form>