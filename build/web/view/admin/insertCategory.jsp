<%-- 
    Document   : insertCategory
    Created on : Mar 9, 2022, 5:29:41 PM
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
            <input type="text" name = "categoryName" />
            ${requestScope.message_ExistCategoryName}
            <br/>
            <input type="submit" value = "save">
        </form>
    </body>
</html>
