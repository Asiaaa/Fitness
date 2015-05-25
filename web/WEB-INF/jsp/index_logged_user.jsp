<%-- 
    Document   : index_logged
    Created on : 2015-05-24, 20:38:10
    Author     : Joanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
             <h1>Pomyślnie zalogowano!</h1>
     <form-login
        authentication-failure-url="/secure/loginUser.do?error=true"
        login-page="/secure/loginUser.do" />
            
           Możesz się wylogować:
         <a href="j_spring_security_logout" />  Logout </a>
    </body>
</html>
