<%-- 
    Document   : login
    Created on : 2015-05-24, 20:37:45
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
        authentication-failure-url="/secure/loginAdmin.do?error=true"
        login-page="/secure/loginAdmin.do" />
            
           Możesz się wylogować:
         <a href="j_spring_security_logout" />  Logout </a>
    </form>
     
    </body>
</html>
