<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 15.09.2019
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/" var="mainURL"/>

<html>
<head>
    <title>witaj w salonie Sanita</title>
    <%--    bootstramp--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <%--    fontawesome.com--%>
    <script src="https://kit.fontawesome.com/f84d87b17f.js" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans|Playfair+Display&display=swap" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${mainURL}resources/css/body.css">

    <script src="${mainURL}resources/js/setInputFilter.js"></script>
    <link rel="stylesheet" href="${mainURL}resources/css/simple-calendar.css">
    <style>
        body {
            font-family: 'Playfair Display', serif;
            font-size: 18px;
            /*text-shadow: 1px 1px 1px #aaa;*/
        }

    </style>

</head>

<body>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
    <a class="fas fa-shoe-prints" href="<c:url value="/"/>"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="/"/>">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <c:choose>

                    <c:when test="${sessionScope.User.getName() != null}">
                    <a class="nav-link">Witaj ${sessionScope.User.getName()}</a>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/logout"/> ">Wyloguj się</a>
                </li>
                </c:when>
                <c:otherwise>
                    <a class="nav-link" href="<c:url value="/login"/> ">Zaloguj się</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/register"/> ">Zarejestruj się</a>
                    </li>
                </c:otherwise>
                </c:choose>

            </ul>
        </form>
    </div>
</nav>

