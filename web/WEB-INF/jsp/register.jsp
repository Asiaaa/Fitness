<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<div id="context">
    <div id="con_left">
        <h2>Rejestracja</h2>
        <form:form action="register" method="post" commandName="userForm">
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
        </form:form>
            
         
    </div>
</div>
    </body>
</html>
