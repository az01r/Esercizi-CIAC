<%-- 
    Document   : elenco-prodotti
    Created on : 27 apr 2020, 14:26:05
    Author     : alfonso
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Elenco Prodotti</title>
    </head>
    <body>
        <h1>Elenco prodotti</h1>
        <ul>    
            <c:set var="prodotti" value="${prodController.all()}" />
            <c:forEach items="${prodotti}" var="p">
                <li>
                    ${p.id} - ${p.nome}
                </li>
            </c:forEach>
            <c:if test="${empty prodotti}">
                <p>Nessun prodotto presente a catalogo</p>
            </c:if>
        </ul>
    </body>
</html>
