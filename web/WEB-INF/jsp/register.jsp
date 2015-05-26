<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<div id="context">
    <div id="con_left">
        
        <div id="formularz" style="margin-left: 50px">
            <h2>Rejestracja</h2>
        <table>
        <form>
            <tr><td>login: </td><td><input type="text" name="login" value="" /></td></tr>
            <tr><td>hasło: </td><td><input type="password" name="haslo" value="" /></td></tr>
            <tr><td>Imie: </td><td><input type="text" name="imie" value="" /></td></tr>
            <tr><td>Nazwisko: </td><td><input type="text" name="nazwisko" value="" /></td></tr>
            <tr><td>email: </td><td><input type="text" name="email" value="" /></td></tr>
            <tr><td>telefon: </td><td><input type="text" name="telefon" value="" /></td></tr>
            <tr><td><input type="submit" value="Wyślij" /></td></tr>
        </form>
        </table>
        </div>
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
