<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 21.09.2019
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>

<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Imię</th>
        <th scope="col">Nazwisko</th>
        <th scope="col">email</th>
        <th scope="col">nr telefonu</th>
        <th scope="col">akcje</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${allClients}" var="clients">
    </tr>
    <tr>
        <th scope="row">${clients.id}</th>
        <td>${clients.firstName}</td>
        <td>${clients.lastName}</td>
        <td>${clients.email}</td>
        <td>${clients.phoneNumber}</td>
        <td>
            <a href="<c:url value="/procedures/create"><c:param name="id" value="${clients.id}"/></c:url> ">
                <button style="color: blue">edycja</button>
            </a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<jsp:include page="footer.jsp"/>