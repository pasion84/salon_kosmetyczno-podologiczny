<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 29.09.2019
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<form:form method="post" modelAttribute="allWorkers">
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Imię</th>
        <th scope="col">akcje</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${allWorkers}" var="workers">
    </tr>
    <tr>
        <td>${workers.firstName}</td>
        <td>
            <form:radiobutton path="empty" value="${workers.id}" label=" - wybierz"/>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</form:form>
<br>
<a href="<c:url value="/procedures/add"/> ">
    <button type="button" class="btn btn-primary btn-lg" slot="center">umów się na wizytę</button>
</a>
<jsp:include page="footer.jsp"/>
