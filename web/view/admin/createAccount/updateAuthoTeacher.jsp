<%-- 
    Document   : updateTeacher
    Created on : Mar 18, 2022, 2:49:36 AM
    Author     : pv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "view-update" method="POST">
            <table border = "1px">
                <th>Account</th>
             <c:forEach items="${requestScope.groups}" var="g">
                <th>${g.name}</th>
             </c:forEach>
             <c:forEach items="${requestScope.getAccountsEmployee}" var = "a">   
                <tr>
                        <td>${a.fullname}  (${a.username})</td>
                        <c:forEach items="${requestScope.groups}" var="g">
                        <td>
                            <input type="checkbox" name="user_group" value="${a.username}_${g.id}"
                               <c:forEach items = "${a.groups}" var="ag" >
                                   <c:if test = "${ag.id == g.id}">checked="checked"</c:if>
                               </c:forEach>      
                            />
                         </td>   
                        </c:forEach>
                </tr>
             </c:forEach>   
            </table>
            <input type ="submit" value ="Save" />
        </form>    
    </body>
</html>
