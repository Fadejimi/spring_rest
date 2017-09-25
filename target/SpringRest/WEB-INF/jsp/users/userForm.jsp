<%--
  Created by IntelliJ IDEA.
  User: Fadejimi
  Date: 19/09/2017
  Time: 6:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
    <%@ include file="../fragments/header.jspf" %>
<body>
<div class="container">

    <c:choose>
    <c:when test="${userForm['new']}">
    <h1>Add User</h1>
    </c:when>
    <c:otherwise>
    <h1>Update User</h1>
    </c:otherwise>
    </c:choose>
    <br />

    <spring:url value="/users" var="userActionUrl" />


    <form:form class="form-horizontal" method="post" modelAttribute="userForm" action="${userActionUrl}">
        <form:hidden path="id" />

        <spring:bind path="username">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Username</label>
            <div class="col-sm-10">
                <form:input path="username" type="text" class="form-control"
                            id="username" placeholder="Username" />
                <form:errors path="username" class="control-label" />
            </div>
        </div>
    </spring:bind>

    <spring:bind path="email">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <form:input path="email" class="form-control"
                            id="email" placeholder="Email" required="true"/>
                <form:errors path="email" class="control-label" />
            </div>
        </div>
    </spring:bind>

    <spring:bind path="password">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <form:password path="password" class="form-control"
                               id="password" placeholder="password" required="true"/>
                <form:errors path="password" class="control-label" />
            </div>
        </div>
    </spring:bind>

    <spring:bind path="confirmPassword">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">confirm Password</label>
            <div class="col-sm-10">
                <form:password path="confirmPassword" class="form-control"
                               id="password" placeholder="password" required="true"/>
                <form:errors path="confirmPassword" class="control-label" />
            </div>
        </div>
    </spring:bind>

    <spring:bind path="gender">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Gender</label>
            <div class="col-sm-10">
                <label class="radio-inline">
                    <form:radiobutton path="gender" value="M" /> Male
                </label>
                <label class="radio-inline">
                    <form:radiobutton path="gender" value="F" /> Female
                </label> <br />
                <form:errors path="gender" class="control-label" />
            </div>
        </div>
    </spring:bind>

    <spring:bind path="beerKind">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Beer Brand</label>
            <div class="col-sm-5">
                <form:select path="beerKind" items="${beers}"
                             multiple="true" size="5" class="form-control" />
                <form:errors path="beerKind" class="control-label" />
            </div>
            <div class="col-sm-5"></div>
        </div>
    </spring:bind>

    <spring:bind path="interests">
        <div class="form-group ${status.error ? 'has-error' : ''}">
            <label class="col-sm-2 control-label">Interests</label>
            <div class="col-sm-10">
                <form:checkboxes path="interests" items="${interests}"
                                 element="label class='checkbox-inline'" />
                <br />
                <form:errors path="interests" class="control-label" />
            </div>
        </div>
    </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${userForm['new']}">
                        <button type="submit" class="btn-lg btn-primary pull-right">Add
                        </button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn-lg btn-primary pull-right">Update
                        </button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

    </form:form>
    <%@ include file="../fragments/footer.jspf"%>
</body>
</html>
