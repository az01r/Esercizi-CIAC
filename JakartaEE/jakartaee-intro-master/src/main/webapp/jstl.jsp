<%-- 
    Document   : test
    Created on : 23 apr 2020, 12:49:04
    Author     : alfonso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Test</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
    <body>
        <div>
            <h1>Test JakartaEE .....</h1>
            <p>funziona tutto... o quasi...</p>
            <ul>
                
                <c:forEach begin="1" end="10" var="x">
                    <li>
                        <c:out value="${x}" />
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>

