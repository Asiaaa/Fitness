<%-- 
    Document   : edit_user
    Created on : 2015-05-31, 19:44:19
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
        <title>Edytuj użytkownika</title>
    </head>
    <body>
        <div id="context">
    <div id="con_left">
        
        <div id="formularz" style="margin-left: 50px">
            <h2>Edycja ${command.imie}</h2>
       <table>
           <form:form method="POST" action="" commandName="command">
            <tr><td><form:label path="login">Login: </form:label> </td><td><form:input path="login" /></td></tr>
            <tr><td><form:label path="imie">Imię: </form:label></td><td><form:input path="imie" /></td></tr>
            <tr><td><form:label path="nazwisko">Nazwisko: </form:label></td><td><form:input path="nazwisko" /></td></tr>
            <tr><td><form:label path="email">Email: </form:label></td><td><form:input path="email" /></td></tr>
            <tr><td><form:label path="telefon">Telefon: </form:label></td><td><form:input path="telefon" /></td></tr>
            <tr><td><form:label path="rola">Rola: </form:label></td><td><form:select path="rola" items="${['ROLE_USER', 'ROLE_STAFF', 'ROLE_INSTRUCTOR']}"></form:select></td></tr>
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
