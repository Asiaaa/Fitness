<%-- 
    Document   : zarzadzaj_grafik_fitness
    Created on : 2015-06-01, 19:36:26
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
        <title>Zarządzaj grafikiem fitness</title>
    </head>
    <body>
        <div id="context">
        <c:if test="${not empty grafikf}">
            <table id="zarzadzanko">
                <tr><th>Nazwa</th>
                    <th>Prowadzacy</th>
                    <th>Start</th>
                    <th>Koniec</th>
                    <th>Dzień tygodnia</th>
                    <th>Edytuj</th>
                    <th>Usuń</th>
            <c:forEach items="${grafikf}" var="i">
                <tr><td>${i.zajecia}</td>
                    <td>${i.imie} ${i.nazwisko}</td>
                    <td>${i.godzStart}</td>
                    <td>${i.godzKoniec}</td>
                    <td>${i.dzienTygodnia}</td>
                    <td><a href="<c:url value="/edytuj_grafik_fitness.htm?id=${i.idGrafikFitness}"/>"><i class="fa fa-pencil-square-o"></i></a></td>
                    <td><a href="<c:url value="/usun_grafik_fitness.htm?id=${i.idGrafikFitness}"/>"><i class="fa fa-times"></i></a></td>
                    </tr>
            </c:forEach>
        </c:if>
            </table>
            <table id="dodajgr">
                <tr><td><a href="<c:url value="/dodaj_grafik_fitness.htm"/>">DODAJ WPIS</a></td></tr>
            </table>
        </div>
    </body>
</html>
