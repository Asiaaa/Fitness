<%-- 
    Document   : add_zajecia
    Created on : 2015-06-01, 18:54:25
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
        <title>Dodaj zajęcia</title>
    </head>
    <body>
        <div id="context">
    <div id="con_left">
        
        <div id="formularz" style="margin-left: 50px">
            <h2>Dodaj</h2>
       <table>
           <form:form method="POST" action="add_zajecia.htm">
            <tr><td><form:label path="nazwa">Nazwa: </form:label> </td><td><form:input path="nazwa" /></td></tr>
            <tr><td><form:label path="czasTrwania">Czas trwania: </form:label></td><td><form:input path="czasTrwania" /></td></tr>
            <tr><td><form:label path="idStopienTrudnosci">Stopien trudnosci: </form:label></td><td><form:select path="idStopienTrudnosci" items="${stopnie}" ></form:select></td></tr>
            <tr><td><form:label path="opis">Opis: </form:label></td><td><form:input path="opis" /></td></tr>
            <tr><td><input type="submit" value="Wyślij" /></td></tr>
         </form:form>
        </table>
        </div>
    </div>
        <div id="con_right">
            <h2>Uwaga</h2>
            Wszystkie pola są wymagane. 
        </div>
</div>
    </body>
</html>
