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

        <h1>All Users</h1>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>#ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Interests</th>
                <th>Action</th>
            </tr>
            </thead>

            <c:forEach var="user" items="${users}">
                <tr>
                    <td>
                            ${user.id}
                    </td>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>
                        <c:forEach var="interest" items="${user.interests}"
                                   varStatus="loop">
                            ${interest}
                            <c:if test="${not loop.last}">,</c:if>
                        </c:forEach>
                    </td>
                    <td>
                        <spring:url value="/users/${user.id}" var="userUrl" />
                        <spring:url value="/users/${user.id}/delete" var="deleteUrl" />
                        <spring:url value="/users/${user.id}/update" var="updateUrl" />

                        <button class="btn btn-info"
                                onclick="location.href='${userUrl}'">Query</button>
                        <button class="btn btn-primary"
                                onclick="location.href='${updateUrl}'">Update</button>
                        <button class="btn btn-danger"
                                onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <%@ include file="../fragments/footer.jspf" %>
</body>
</html>
