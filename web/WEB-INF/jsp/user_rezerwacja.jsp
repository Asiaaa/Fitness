<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<div id="context">
    <div id="formularz">
        <h2>Twoje zajęcia</h2>
        <ul>
            <c:forEach items="${rezerwacjaLista}" var="r">
                <c:forEach items="${grafikLista}" var="i">                            
                    <c:if test="${r.getIdGrafikFitness()==i.getIdGrafikFitness()}">
                        <li><c:out value="${i.getZajecia()} ${i.getDzienTygodnia()}(${i.getGodzStart()}.00 - ${i.getGodzKoniec()}.00)"/>
                            <a href="<c:url value="/user_rezerwacja_usun.htm?id=${r.getIdRezerwacja()}"/>">wypisz się</a></li>
                    
                    </c:if>
                </c:forEach>
            </c:forEach>
        </ul>
        <h2>Utwórz dodatkowe rezerwacje</h2>
    <table>
        <form:form method="POST" action="user_rezerwacja.htm" commandName="command">
            <tr><td><form:label path="idGrafikFitness">Dostępne zajęcia</form:label>
                    <form:select path="idGrafikFitness">
                        <c:forEach items="${grafikLista}" var="i">
                            <form:option value="${i.getIdGrafikFitness()}">${i.getZajecia()} ${i.getDzienTygodnia()}(${i.getGodzStart()}.00 - ${i.getGodzKoniec()}.00)</form:option>
                        </c:forEach>
                    </form:select>
            <tr><td><input type="submit" value="Wyślij" /></td></tr>
         </form:form>
    </table>
    </div>
    
</div>
</body>
</html>