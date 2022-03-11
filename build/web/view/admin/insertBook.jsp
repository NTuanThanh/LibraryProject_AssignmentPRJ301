<%-- 
    Document   : insertBook
    Created on : Mar 11, 2022, 9:15:22 PM
    Author     : pv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "insert" method="POST" enctype="multipart/form-data">
        Tên Sách : <input type="text" name = "bname"/> <br>
        Nhà Xuất Bản : 
        <select name = "publisher_id">  
            <c:forEach items="${requestScope.publishers}" var = "p">
                <option value="${p.id}">${p.name}</option>
            </c:forEach>
        </select> <br>
        Thể Loại : 
        <select name="category_id"> 
            <c:forEach items="${requestScope.categories}" var = "c">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>                   
        </select> <br>
        Mô tả : <textarea name = "descrip"></textarea> <br>
        Năm Xuất Bản : <input type="text" name = "publication_year" /><br>
        Ngôn Ngữ : 
        <select name = "language_id"> 
            <c:forEach items="${requestScope.languages}" var = "l">
                <option value="${l.id}">${l.name}</option>
            </c:forEach>
        </select><br>
        Tác Giả : <input type="text" name = "author"/><br>
        Số Trang : <input type="text" name = "numberpage"> <br>
        Vị trị đặt sách ở thư viện: <input type="text" name = "location"> <br>
        Ảnh : <input type ="file" name = "img"/><br>
        <input type="submit" value = "Thêm"> 
        <input type="reset" value = "Reset">
        </form>
    </body>
</html>
