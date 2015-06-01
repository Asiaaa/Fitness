<%-- 
    Document   : edit_grafik_fitness
    Created on : 2015-06-02, 00:24:07
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
        <title>Edytuj grafik fitness</title>
    </head>
    <body>
        <div id="context">
    <div id="con_left">
        
        <div id="formularz" style="margin-left: 50px">
            <h2>Edycja ${command.zajecia} ${command.dzienTygodnia}</h2>
       <table>
           <form:form method="POST" action="" commandName="command">
            <%--<tr><td><form:label path="idInstruktor">Instruktor: </form:label></td><td><form:select path="idInstruktor" items="${instr}" ></form:select></td></tr>--%>
            <tr><td><form:label path="godzStart">Godzina rozpoczecia: </form:label> </td><td><form:input path="godzStart" /></td></tr>
            <tr><td><form:label path="godzKoniec">Godzina zakończenia: </form:label></td><td><form:input path="godzKoniec" /></td></tr>
            <tr><td><form:label path="idDzienTygodnia">Dzień tygodnia: </form:label></td><td><form:select path="idDzienTygodnia" items="${dni}" ></form:select></td></tr>
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
