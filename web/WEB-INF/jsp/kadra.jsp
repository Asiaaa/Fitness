<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="context">
    <h2>Nasz zespół</h2>
    <c:forEach items="${userLista}" var="instruktor">
        <c:out value="${instruktor.getImie()}"/>
        <c:out value="${instruktor.getNazwisko()}"/>
        <c:forEach items="${grafikLista}" var="zajecia">
            <ul>
                <c:if test="${zajecia.getIdInstruktor() == instruktor.getIdUzytkownik()}">
                    <li>
                    <c:out value="${zajecia.getZajecia()}"/>
                    </li>
                </c:if>
            </ul>
        </c:forEach>
    </c:forEach>
</div>
    </body>
</html>
