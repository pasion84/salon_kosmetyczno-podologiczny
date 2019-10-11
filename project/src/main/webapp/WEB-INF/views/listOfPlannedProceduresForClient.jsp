<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 10.10.2019
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<main role="main" class="flex-shrink-0">
    <br>
    <form:form method="get" modelAttribute="viewPlannedProceduresForClient">
        <%--    <form:hidden path="id"/>--%>
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">pracownik</th>
                <th scope="col">data wizyty</th>
                <th scope="col">akcje</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <c:forEach items="${viewPlannedProceduresForClient}" var="procedures">
            </tr>
            <tr>
                <td>${procedures.id}</td>
                <td>${procedures.worker.firstName}</td>
                <td>${procedures.dateAndTimeOfProcedure}</td>
                <td>
                        <%--                usuwanie i edycja zaplanowanej wizyty--%>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </form:form>
    <br>
    <a href="<c:url value="/plannedProcedure/planProcedureToClient"/> ">
        <button type="button" class="btn btn-primary btn-lg" slot="center">umów się na kolejną wizytę</button>
    </a>
</main>
<jsp:include page="footer.jsp"/>
