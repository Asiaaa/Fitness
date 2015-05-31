<%-- 
    Document   : zarzadzaj_uzytkownicy
    Created on : 2015-05-31, 14:57:06
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
        <title>Zardządzaj użytkownikami</title>
    </head>
    <body>
        <div id="context">
        <c:if test="${not empty users}">
            <table id="zarzadzanko">
                <tr><th>Login</th>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Email</th>
                    <th>Telefon</th>
                    <th>Rola</th>
                    <th>Edytuj</th>
                    <th>Usuń</th></tr>
            <c:forEach items="${users}" var="i">
                <tr><td>${i.login}</td>
                    <td>${i.imie}</td>
                    <td>${i.nazwisko}</td>
                    <td>${i.email}</td>
                    <td>${i.telefon}</td>
                    <td>${i.rola}</td>
                    <td><a href="<c:url value="/edytuj_uzytkownika.htm?id=${i.id}"/>"><i class="fa fa-pencil-square-o"></i></a></td>
                    <td><a href="<c:url value="/usun_uzytkownika.htm?id=${i.id}"/>"><i class="fa fa-times"></i></a></td>
                    </tr>
            </c:forEach>
        </c:if>
            </table>
        </div>
    </body>
</html>
