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
<%--    date time picker style--%>
<link rel="stylesheet" type="text/css" href="${mainURL}resources/css/datePicker.css"/>
<script src="${mainURL}resources/js/setInputFilter.js"></script>
<script src="${mainURL}resources/js/jquery.js"></script>
<script src="${mainURL}resources/js/dateTimePicker.js"></script>
<style type="text/css">
    .custom-date-style {
        background-color: red !important;
    }

    .input {
    }

    .input-wide {
        width: 500px;
    }
</style>

<main role="main" class="flex-shrink-0">
    <br>
    <form:form method="post" modelAttribute="addClientProcedure">


        <div class="form-group">
            <p>wybierz pracownika</p>
            <c:forEach items="${allWorkers}" var="workers">
                <form:radiobutton path="workerId" value="${workers.id}" label=" ${workers.firstName}"/>
            </c:forEach>
        </div>


        <div class="form-group">
            <p>wybierz zabieg</p>
            <c:forEach items="${cosmeticProcedureList}" var="procedureList" varStatus="status">
                <form:radiobutton path="cosmeticProcedureId" value="${procedureList.id}"
                                  label="${procedureList.name}"/> || ${procedureList.price}<br>
            </c:forEach>
        </div>
        <h5>Wybierz datę i godzinę</h5>
        <input type="text" value="" id="datetimepicker"/><br><br>


        <script>

            $.datetimepicker.setLocale('pl');
            $('#datetimepicker_format').datetimepicker({
                value: '2015/04/15 05:03',
                format: $("#datetimepicker_format_value").val()
            });
            console.log($('#datetimepicker_format').datetimepicker('getValue'));
            $("#datetimepicker_format_change").on("click", function (e) {
                $("#datetimepicker_format").data('xdsoft_datetimepicker').setOptions({format: $("#datetimepicker_format_value").val()});
            });
            $("#datetimepicker_format_locale").on("change", function (e) {
                $.datetimepicker.setLocale($(e.currentTarget).val());
            });
            $('.some_class').datetimepicker();
            jQuery('#datetimepicker').datetimepicker();

        </script>

        <p>
            <input type="submit" value="Zapisz zabieg">
            <input type="reset" value="Wyczysc">
        </p>
    </form:form>
    <br>
</main>
<jsp:include page="footer.jsp"/>