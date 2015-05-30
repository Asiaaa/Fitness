<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<div id="context">
    <div id="con_left">
        
        <div id="formularz" style="margin-left: 50px">
            <h2>Rejestracja</h2>
       <table>
        <form:form method="POST" action="register.htm">
            <tr><td><form:label path="login">Login: </form:label> </td><td><form:input path="login" /></td></tr>
            <tr><td><form:label path="haslo">Hasło: </form:label></td><td><form:input path="haslo" /></td></tr>
            <tr><td><form:label path="imie">Imię: </form:label></td><td><form:input path="imie" /></td></tr>
            <tr><td><form:label path="nazwisko">Nazwisko: </form:label></td><td><form:input path="nazwisko" /></td></tr>
            <tr><td><form:label path="email">Email: </form:label></td><td><form:input path="email" /></td></tr>
            <tr><td><form:label path="telefon">Telefon: </form:label></td><td><form:input path="telefon" /></td></tr>
            <tr><td><input type="submit" value="Wyślij" /></td></tr>
         </form:form>
        </table>
        </div>
            ${imie}
        <%--<form:form modelAttribute="Uzytkownik" method="post">
            <table border="0">
                <tr><td>Login:</td><td><form:input path="login"/></td></tr>
                <tr><td>Haslo:</td><td><form:password path="haslo"/></td></tr>
                <tr><td>Imie:</td><td><form:input path="imie"/></td></tr>
                <tr><td>Nazwisko:</td><td><form:input path="nazwisko"/></td></tr>
                <tr><td>e-mail:</td><td><form:input path="email"/></td></tr>
                <tr><td>telefon:</td><td><form:input path="telefon"/></td></tr>
                <tr><td>opis:</td><td><form:input path="opis"/></td></tr>
                <tr><td colspan="2" align="center"><input type="submit" value="Register" /></td></tr>
            </table>
        </form:form>--%>
            
         
    </div>
        <div id="con_right">
            <h2>Uwaga</h2>
            Wszystkie pola są wymagane. 
        </div>
</div>
    </body>
</html>
