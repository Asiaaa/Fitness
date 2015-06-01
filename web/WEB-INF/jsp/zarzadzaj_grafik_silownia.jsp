<%-- 
    Document   : zarzadzaj_grafik_silownia
    Created on : 2015-06-01, 21:18:17
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
        <title>Zarządzaj grafikiem siłowni</title>
    </head>
    <body>
        <div id="context">
        <c:if test="${not empty grafik}">
            <table id="zarzadzanko">
                <tr><th>Dzien tygodnia</th>
                    <th>Od</th>
                    <th>Do</th>
                    <th>Instruktor</th>
                    <th>Edytuj</th>
                    <th>Usuń</th>
            <c:forEach items="${grafik}" var="i">
                <tr><td>${i.ddzienTygodnia}</td>
                    <td>${i.godzStart}</td>
                    <td>${i.godzEnd}</td>
                    <td>${i.imie} ${i.nazwisko}</td>
                    <td><a href="<c:url value="/edytuj_grafik_silownia.htm?id=${i.id}"/>"><i class="fa fa-pencil-square-o"></i></a></td>
                    <td><a href="<c:url value="/usun_grafik_silownia.htm?id=${i.id}"/>"><i class="fa fa-times"></i></a></td>
                    </tr>
            </c:forEach>
        </c:if>
            </table>
            <table id="dodajgr">
                <tr><td><a href="<c:url value="/dodaj_grafik_silownia.htm"/>">DODAJ WPIS</a></td></tr>
            </table>
        </div>
    </body>
</html>
