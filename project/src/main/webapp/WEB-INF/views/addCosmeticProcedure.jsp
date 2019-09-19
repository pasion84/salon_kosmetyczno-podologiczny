<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 19.09.2019
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<body>
<form:form method="post" modelAttribute="procedure">
<p>
    Nazwa Zabiegu: <form:input path="name"/>
    <form:errors path="name"/>
</p>
<p>
    Cena zabiegu: <form:input path="price"/>
    <form:errors path="price"/>
</p>
<p>
    Czas trwania zabiegu w minutach: <form:input path="durationOfProcedureInMinutes"/>
    <form:errors path="durationOfProcedureInMinutes"/>
</p>

<p>
    <input type="submit" value="Zapisz zabieg">
    <input type="reset" value="Wyczysc">
</p>
</form:form>
<br>
<jsp:include page="footer.jsp"/>
