<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 05.10.2019
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<body>
<c:url value="/" var="mainURL"/>
<script src="${mainURL}resources/js/setInputFilter.js"></script>
<br>
<script>
    setInputFilter(document.getElementById("floatTextBox"), function (value) {
        return /^-?\d*[.,]?\d*$/.test(value);
    });

</script>

<form:form method="post" modelAttribute="editClient">
    <%--    <form:hidden path="id"/>--%>
    <p>
        Email: <form:input path="email" type="email"/>
        <form:errors path="email"/>
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
        Haslo: <form:password path="password"/>
        <form:errors path="password"/>
    </p>
    <%--    <p>--%>
    <%--        Powtórz haslo: <form:password path="password"/>--%>
    <%--        <form:errors path="password"/>--%>
    <%--    </p>--%>


    <p>
        Nr telefonu: <form:input path="phoneNumber"/>
        <form:errors path="phoneNumber"/>
    </p>
    <p>
    <p>
        NIP: <form:input path="nip"/>
        <form:errors path="nip"/>
    </p>
    <p>
        Rola:
        <form:select path="role">
            <form:option value="ROLE_ADMIN">ADMIN</form:option>
            <form:option value="ROLE_WORKER">PRACOWNIK</form:option>
            <form:option value="ROLE_USER">KLIENT</form:option>
        </form:select>
        <form:errors path="role"/>
    </p>
    <p>
        Address: <form:input path="address"/>
        <form:errors path="address"/>
    </p>
    <p>
        Salary per hour: <form:input path="salaryPerHour" id="floatTextBox"/>
        <form:errors path="salaryPerHour"/>
    </p>

    <%--working time--%>

    <p>
        <input type="submit" value="Uaktualnij dane">
        <input type="reset" value="Wyczysc">
    </p>
</form:form>
<br>
</body>
<jsp:include page="footer.jsp"/>
