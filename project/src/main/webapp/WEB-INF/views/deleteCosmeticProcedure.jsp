<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 21.09.2019
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<form:form method="delete" modelAttribute="deleteProcedure">
    <form:hidden path="id"/>
    <div class="card text-center">
        <div class="card-header">
            Czy usunąć?
        </div>
        <div class="card-body">
            <h5 class="card-title">Czy usunąć zabieg ${deleteProcedure.name}?</h5>
            <p class="card-text">Zabieg o id ${deleteProcedure.id}, nazwie ${deleteProcedure.name},
                cenie ${deleteProcedure.price} zostanie usunięty</p>
            <input type="submit" class="btn btn-danger" value="Usuń">
            <a href="<c:url value="/procedures"/> ">
                <button class="btn btn-primary">powrót do listy</button>
            </a>
        </div>
        <div class="card-footer text-muted">
            2 days ago
        </div>
    </div>

</form:form>
<br>
<jsp:include page="footer.jsp"/>