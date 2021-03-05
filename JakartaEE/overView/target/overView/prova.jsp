<%-- 
    Document   : prova
    Created on : 5 mar 2021, 11:51:05
    Author     : Paolo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <ul>
            <c:forEach begin="1" end="20" var="count">
                <li><c:out value="${count}"></c:out></li>
            </c:forEach>
        </ul>
    </body>
</html>
