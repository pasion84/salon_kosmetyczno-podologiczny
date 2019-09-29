<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 15.09.2019
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<body>
<form:form method="post" modelAttribute="data">
<p>
    Email: <form:input path="email" type="email"/>
    <form:errors path="email"/>
</p>
<p>
    Haslo: <form:password path="password"/>
    <form:errors path="password"/>
</p>
<p>
    Powtórz hasło: <form:password path="rePassword"/>
    <form:errors path="rePassword"/>
</p>
<p>
    Imie: <form:input path="firstName"/>
    <form:errors path="firstName"/>
</p>
<p>
    Nazwisko: <form:input path="lastName"/>
    <form:errors path="lastName"/>
</p>
<p>
    Nr telefonu: <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
</p>
<p>
<p>
    NIP: <form:input path="nip"/>
    <form:errors path="nip"/>
</p>

Rola:
<form:select path="role">
<form:option value="ROLE_ADMIN">ADMIN</form:option>
<form:option value="ROLE_WORKER">PRACOWNIK</form:option>
<form:option value="ROLE_USER">KLIENT</form:option>
</form:select>
    <form:errors path="role"/>
</p>

<p>
    <input type="submit" value="Zarejestruj">
    <input type="reset" value="Wyczysc">
</p>
</form:form>
<br>
<jsp:include page="footer.jsp"/>

