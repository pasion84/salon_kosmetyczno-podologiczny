<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 29.09.2019
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<a href="<c:url value="/procedures/create"/>">
    <button>dodaj nowy zabieg</button>
</a>

<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">nazwa zabiegu</th>
        <th scope="col">czas trwania</th>
        <th scope="col">cena w zł</th>
        <th scope="col">akcje</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${procedureList}" var="procedureList">
    </tr>
    <tr>
        <th scope="row">${procedureList.id}</th>
        <td>${procedureList.name}</td>
        <td>${procedureList.durationOfProcedureInMinutes}</td>
        <td>${procedureList.price}</td>
        <td>
            <a href="<c:url value="/procedures/create"><c:param name="id" value="${procedureList.id}"/></c:url> ">
                <button style="color: blue">edycja</button>
            </a>
            <a href="<c:url value="/procedures/delete"><c:param name="id" value="${procedureList.id}"/></c:url> ">
                <button>usuń</button>
            </a>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
