<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="org.springframework.jdbc.core.RowMapper"%>
<%@page import="Model.Grafik_fitness"%>
<%@page import="java.util.List"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="context">
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
        <%
            
            //Grafik_fitness gr = new Grafik_fitness();
            //gr.setDataSource(datasource);
            //List<Grafik_fitness> grafik = gr.getAll();
            
            for(int i=0; i<7; i++)
            {
                out.println("<td align=center valign=middle width=100>");
                    //for(Grafik_fitness x : grafik){
                      //  out.println(x.getGodzStart());
                    //}
                out.println("</td>");
            }  
            
            
            
            %>
        <%--<c:forEach begin="0" end="6" step="1" var="day">
        <TD align="center" valign="middle" width="100">
           
        <c:forEach items="${Grafik_fitness.getAll()}" var="clazz">
        <c:if test="${clazz.getGodzStart() <= time 
        && clazz.getGodzKoniec() > time 
        && clazz.getIdDzienTygodnia() == day}">
              </c:if>
        <c:out value="${clazz.getIdZajecia()}" />
        
        </c:forEach>
        </TD>
        </c:forEach>--%>
    </TR>
</c:forEach>
</TBODY>
</TABLE>
</div>