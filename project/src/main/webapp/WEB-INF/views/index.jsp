<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 15.09.2019
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<c:url value="/" var="mainURL"/>
<script src="${mainURL}resources/js/jquery.simple-calendar.js"></script>
<br>
<a href="<c:url value="/procedures"/>">
    <button type="button" class="btn btn-primary">Lista zabiegów</button>
</a>
<br>
<a href="<c:url value="/procedures/planProcedureToClient"/>">
    <button type="button" class="btn btn-primary">umów się na wizytę</button>
</a>

<br>
<div class="col-sm-3">
    <div id="container" class="calendar-container"></div>
    <script>
        $(document).ready(function () {
            $("#container").simpleCalendar({
                fixedStartDay: false
            });
        });
    </script>
</div>
<br>
<jsp:include page="footer.jsp"/>
