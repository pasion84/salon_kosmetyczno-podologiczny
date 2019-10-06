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
<form:form method="post" modelAttribute="principal">

    <form:hidden path="email" value="${client.id}"/>

    <p>ssssssss + ${client.id} ${clientService.email} ${addClientProcedure.clientId} ${client.id}</p>

        <div class="form-group">
            <label for="exampleFormControlSelect1">Pracownik</label>

            <form:select path="id" class="form-control" id="exampleFormControlSelect1">
                <c:forEach items="${allWorkers}" var="workers">
                    <form:radiobutton path="id" value="${client.id}" label=" ${workers.firstName}"/>
                </c:forEach>
            </form:select>
        </div>


    <div class="form-group">
            <label for="exampleFormControlSelect2">Usługa</label>
        <form:select path="plannedProcedure" multiple="form-control" id="exampleFormControlSelect2">
                <c:forEach items="${procedureList}" var="procedureList">
                    <form:checkbox path="id" value="${procedureList.id}"
                                   label="${procedureList.name}"/> || ${procedureList.price}<br>
                </c:forEach>
        </form:select>
        </div>
        <p>
            <input type="submit" value="Zapisz zabieg">
            <input type="reset" value="Wyczysc">
        </p>
</form:form>
<br>
<jsp:include page="footer.jsp"/>