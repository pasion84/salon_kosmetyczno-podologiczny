<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 15.09.2019
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<h1>strona logowania</h1>
<c:choose>
    <c:when test="${param.error != null}">
        <p>Błędne dane logowania!</p>
    </c:when>
    <c:when test="${param.logout != null}">
        <p>Poprawnie wylogowano</p>
    </c:when>
</c:choose>
<form:form method="post" modelAttribute="data">
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
               placeholder="Enter email"/>
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <form:password path="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
    </div>
    <div class="form-group form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
<br>
<jsp:include page="footer.jsp"/>
