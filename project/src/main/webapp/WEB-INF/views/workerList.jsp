<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 29.09.2019
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<br>

<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">Imię</th>
        <th scope="col">Nazwisko</th>
        <th scope="col">akcje</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach items="${allWorkers}" var="workers">
    </tr>
    <tr>
        <td>${workers.firstName}</td>
        <td>${workers.lastName}</td>
        <td>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1"
                       checked>
                <label class="form-check-label" for="exampleRadios1">
                    wybierz
                </label>
            </div>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<jsp:include page="footer.jsp"/>
