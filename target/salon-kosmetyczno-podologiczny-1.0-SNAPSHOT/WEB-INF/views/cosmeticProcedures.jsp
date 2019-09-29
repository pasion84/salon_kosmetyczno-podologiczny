<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 19.09.2019
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<%--<div class="btn-group">--%>
<%--    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"--%>
<%--            aria-expanded="false">--%>
<%--        Dodaj zabieg--%>
<%--    </button>--%>
<%--    <div class="dropdown-menu">--%>
<%--        <a class="dropdown-item" href="<c:url value="/procedures" />">Dodaj zabieg</a>--%>
<%--        <a class="dropdown-item" href="#">Another action</a>--%>
<%--        <a class="dropdown-item" href="#">Something else here</a>--%>
<%--        <div class="dropdown-divider"></div>--%>
<%--        <a class="dropdown-item" href="#">Separated link</a>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<a href="<c:url value="/admin/procedures/create"/>">--%>
<%--    <button>dodaj nowy zabieg</button>--%>
<%--</a>--%>
<h4>wybierz zabieg na który chcesz się umówić</h4>
<br>
<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">nazwa zabiegu</th>
        <th scope="col">czas trwania</th>
        <th scope="col">cena w zł</th>
        <th scope="col">dodaj zabieg</th>

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
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                <label class="form-check-label" for="defaultCheck1">
                    dodaj zabieg
                </label>
            </div>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<c:url value="/client/workers"/> ">
    <button type="button" class="btn btn-primary btn-lg" slot="center">wybierz pracownika</button>
</a>
<br>
<jsp:include page="footer.jsp"/>

