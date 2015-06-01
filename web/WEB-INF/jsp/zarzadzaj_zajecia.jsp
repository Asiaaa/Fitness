<%-- 
    Document   : zarzadzaj_zajecia
    Created on : 2015-05-31, 21:10:20
    Author     : Joanna
--%>

<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zardządzaj zajęciami</title>
    </head>
    <body>
        <div id="context">
        <c:if test="${not empty zajecia}">
            <table id="zarzadzanko">
                <tr><th>Nazwa</th>
                    <th>Czas trwania</th>
                    <th>Stopien trudnosci</th>
                    <th>Opis</th>
            <c:forEach items="${zajecia}" var="i">
                <tr><td>${i.nazwa}</td>
                    <td>${i.czasTrwania}</td>
                    <td>${i.stopien}</td>
                    <td>${i.opis}</td>
                    <td><a href="<c:url value="/edytuj_zajecia.htm?id=${i.id}"/>"><i class="fa fa-pencil-square-o"></i></a></td>
                    <td><a href="<c:url value="/usun_zajecia.htm?id=${i.id}"/>"><i class="fa fa-times"></i></a></td>
                    </tr>
            </c:forEach>
        </c:if>
            </table>
            <div id="zarzadzanko">
                <a href="<c:url value="/dodaj_zajecia.htm"/>">DODAJ ZAJĘCIA</a>
            </div>
        </div>
    </body>
</html>
