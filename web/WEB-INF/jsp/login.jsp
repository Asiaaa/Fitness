<%-- 
    Document   : login
    Created on : 2015-05-25, 20:37:06
    Author     : Joanna
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <div id="context">
        <div id="con_left">
        <div id="formularz" style="margin-left: 50px">
            <h2>Logowanie</h2>
        <form action="<c:url value='/j_spring_security_check' />" method='POST'>
            <table>
            <tr><td>Login: </td><td><input type="text" name="j_username" value="" /></td></tr>
            <tr><td>Hasło: </td><td><input type="password" name="j_password" value="" /></td></tr>
            <tr><td><input type="submit" name="submit" value="Zaloguj"/></td></tr>
            </table>
        </form>
            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                <font color="red">
                  Your login attempt was not successful due to 
                  <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
                </font>
            </c:if>
        </div>
        </div>
        </div>
    </body>
</html>
