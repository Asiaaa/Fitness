<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="context">
    <h2>Grafik dla użytkownika 
    <security:authorize access="isAuthenticated()">
<security:authentication property="principal.username" /> 
</security:authorize></h2>
    <TABLE border="1" cellspacing="0">
    <TBODY>
    <TR>
        <TH align="center" valign="middle" width="80"></TH>
        <TH align="center" valign="middle" width="100">Poniedziałek</TH>
        <TH align="center" valign="middle">Wtorek</TH>
        <TH align="center" valign="middle">Środa</TH>
        <TH align="center" valign="middle">Czwartek</TH>
        <TH align="center" valign="middle">Piątek</TH>
        <TH align="center" valign="middle">Sobota</TH>
        <TH align="center" valign="middle">Niedziela</TH>
    </TR>
    <c:forEach begin="8" end="21" step="1" var="time">
    <TR>
        <TD align="center" valign="middle" width="80">
        <c:out value="${time}" />:00
        </TD>
       
        <c:forEach begin="1" end="7" step="1" var="day">
        <TD align="center" valign="middle" width="100">
           
        <c:forEach items="${grafikLista}" var="clazz">
        <c:if test="${clazz.getGodzStart() <= time 
        && clazz.getGodzKoniec() > time 
        && clazz.getIdDzienTygodnia() == day}">
              
        <c:out value="${clazz.getZajecia()}" />
        </c:if>
        </c:forEach>
        <c:forEach items="${grafikSilownia}" var="zajecia">
            <c:if test="${zajecia.getGodzStart() <= time 
        && zajecia.getGodzEnd() > time 
        && zajecia.getDzienTygodnia() == day}">
                <c:out value="siłownia"/>
            </c:if>
        </c:forEach>
        </TD>
        </c:forEach>
    </c:forEach>
</TBODY>
</TABLE>
</div>
</body>
</html>