<%--
  Created by IntelliJ IDEA.
  User: Fadejimi
  Date: 19/09/2017
  Time: 6:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
    <%@ include file="../fragments/header.jspf" %>

<body>
    <div class="container">

        <c:if test="${not empty msg}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>${msg}</strong>
            </div>
        </c:if>

        <h1>User Detail</h1>
        <br />

        <div class="row">
            <label class="col-sm-2">ID</label>
            <div class="col-sm-10">${user.id}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Name</label>
            <div class="col-sm-10">${user.username}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Email</label>
            <div class="col-sm-10">${user.email}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Beer</label>
            <div class="col-sm-10">${user.beerKind}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Sex</label>
            <div class="col-sm-10">${user.gender}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Interests</label>
            <div class="col-sm-10">${user.interests}</div>
        </div>

    </div>

    <%@include file="../fragments/footer.jspf" %>
</body>
</html>
