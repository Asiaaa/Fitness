<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id='context'>
        <h2>Zajęcia</h2>
        <table id="table_zajecia" border="1" cellspacing="0">
            <tr style="font-weight: bold">
                <td width="100">Nazwa</td>
                <td width="100">Czas trwania</td>
                <td width="100">Stopień trudności</td>
                <td >Opis</td>
                </tr>
            <c:forEach items="${zajeciaLista}" var="zajecia">
                <tr>
                    <td><c:out value="${zajecia.getNazwa()}"/></td>
                    <td><c:out value="${zajecia.getCzasTrwania()}"/></td>
                    <td><c:out value="${zajecia.getStopien()}"/></td>
                    <td style="font-size: small; text-align: left"><c:out value="${zajecia.getOpis()}"/></td>
                </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>
