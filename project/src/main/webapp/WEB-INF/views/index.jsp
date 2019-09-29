<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 15.09.2019
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>
<a href="<c:url value="/procedures"/>">
    <button type="button" class="btn btn-primary">Lista zabiegów</button>
</a>

<br>
<jsp:include page="footer.jsp"/>
