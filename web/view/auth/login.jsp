<%-- 
    Document   : login
    Created on : Mar 17, 2022, 2:28:55 AM
    Author     : pv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>       
    </head>
    <body>
        <form action = "login" method = "POST" > 
            Tài khoản :<input type="text" name = "username" /><br/>
            Mật khẩu : <input type="password" name = "password" /><br/>
            <input type="submit" value ="Đăng nhập" />           
        </form>
    </body>
</html>

