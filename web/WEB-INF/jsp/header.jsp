<%-- 
    Document   : header
    Created on : Apr 21, 2015, 2:31:35 PM
    Author     : inka
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fitness</title>
        <link rel="stylesheet" href="css/main.css"/>
    </head>

    <body>
    <nav>
        <h1><a href="index.htm">Fitness Club</a></h1>
        <div id="menu_top">
            <h3>
                <a href="oferta.htm">Oferta | </a>
                <a href="zajecia.htm">Zajęcia | </a>
                <a href="grafik.htm">Grafik | </a>
                <a href="grafik_silownia.htm">Siłownia | </a>
                <a href="kadra.htm">Kadra | </a>
            <security:authorize access="!isAuthenticated()">
            <a href="register.htm">Rejestracja | </a>
            <a href="login.htm">Logowanie</a>  
            </security:authorize>
            <security:authorize access="hasRole('ROLE_USER')">
            <a href="<c:url value='/user' />">Moje konto</a> | 
            </security:authorize>
            <security:authorize access="hasRole('ROLE_ADMIN')">
            <a href="<c:url value='/admin' />">Panel administratora</a> | 
            </security:authorize>
            <security:authorize access="hasRole('ROLE_STAFF')">
            <a href="<c:url value='/admin' />">Zarządzaj</a> | 
            </security:authorize>
             <security:authorize access="hasRole('ROLE_INSTRUCTOR')">
            <a href="<c:url value='/grafik_moj' />">Mój grafik</a> | 
            </security:authorize>
            <security:authorize access="isAuthenticated()">
            <a href="<c:url value='/j_spring_security_logout' />">  Wyloguj</a> | 
            </security:authorize>
            </h3>
        </div>
    </nav>