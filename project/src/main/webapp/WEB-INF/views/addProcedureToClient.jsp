<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 02.10.2019
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<form:form method="post" modelAttribute="addClientProcedure">
    <form:form method="post" modelAttribute="procedureList">
        <div class="form-group">
            <label for="exampleFormControlSelect1">Pracownik</label>
            <form:select path="empty" class="form-control" id="exampleFormControlSelect1">
                <c:forEach items="${allWorkers}" var="workers">
                    <form:option value="${workers.id}" label=" ${workers.firstName}"/>
                </c:forEach>
            </form:select>
        </div>
    </form:form>

    <form:form method="post" modelAttribute="procedureList">
        <div class="form-group">
            <label for="exampleFormControlSelect2">Usługa</label>
            <select multiple class="form-control" id="exampleFormControlSelect2">
                <c:forEach items="${procedureList}" var="procedureList">
                    <form:checkbox path="empty" value="${procedureList.id}" label="${procedureList.name}"/><br>
                </c:forEach>
            </select>
        </div>
        <p>
            <input type="submit" value="Zapisz zabieg">
            <input type="reset" value="Wyczysc">
        </p>


    </form:form>

</form:form>
<br>
<jsp:include page="footer.jsp"/>