<%-- 
    Document   : insertPublisher
    Created on : Mar 10, 2022, 3:00:39 AM
    Author     : pv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Tạm -->
        <form action = "insert" method = "POST">
            <input type="text" name = "publisherName" />
            ${requestScope.message_ExistPublisherName}
            <br/>
            <input type="submit" value = "save">
        </form>
    </body>
</html>
