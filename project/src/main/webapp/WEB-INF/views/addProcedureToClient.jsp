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
<c:url value="/" var="mainURL"/>

<main role="main" class="flex-shrink-0">
    <br>
    <form:form method="post" modelAttribute="addClientProcedure">


        <div class="form-group">
            <p>wybierz pracownika</p>
            <c:forEach items="${allWorkers}" var="workers">
                <form:radiobutton path="workerId" value="${workers.id}" label=" ${workers.firstName}"/>
            </c:forEach>
        </div>

        <form:select path="cosmeticProcedure" itemValue="id" items="${cosmeticProcedureList}" multiple="true"
                     itemLabel="name"/>
        <br>
        <%--        <h5>Wybierz datę i godzinę</h5>--%>
        <%--        <input type="datetime-local" value="2019-10-12T13:16" id="datetimepicker3"/><br><br>--%>
        <div class="form-group">
            <label for="procedureTime">Data i godzina spotkania</label>
            <form:input path="dateAndTimeOfProcedure" cssClass="form-control col-sm-6" id="procedureTime"
                        type="datetime-local" value="${dateAndTimeOfProcedure}"/>
            <form:errors path="dateAndTimeOfProcedure" cssClass="error" element="div"/>
        </div>


        <p>
            <input type="submit" value="Zapisz zabieg">
            <input type="reset" value="Wyczysc">
        </p>
    </form:form>
    <br>
</main>
<jsp:include page="footer.jsp"/>