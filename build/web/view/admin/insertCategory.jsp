<%-- 
    Document   : insertCategory
    Created on : Mar 9, 2022, 5:29:41 PM
    Author     : pv
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="../../css/admin/booksAdmin.css" rel="stylesheet" type="text/css"/>
        <script src="../../js/pagination/pagger.js" type="text/javascript"></script>
        <link href="../../css/admin/insertAdmin.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <!--navbar header-->
        <nav class="position-edit navbar color-brand navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Quản Lý Thư Viện</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto flex-column vertical-nav">
                    <li class="nav-item left-item">
                        <a class="nav-link" href="../../home"><i style="margin-right: 5px" class="fa fa-home"></i>Về Trang Chủ User</a>
                    </li>
                    <li class="nav-item left-item">
                        <a class="nav-link" href="../books"><i style="margin-right: 5px" class="fa fa-book"></i>Quản Lý Sách</a>
                    </li>
                    <li class="nav-item left-item">
                        <a class="nav-link" href="insert">Danh Mục Sách</a>
                    </li>
                    </li>
                    <li class="nav-item left-item">
                        <a class="nav-link" href="#">Nhà Xuất Bản</a>
                    </li>
                    <li class="nav-item left-item">
                        <a class="nav-link" href="#">Lượt mượn ngày hôm nay</a>
                    </li>
                    <li class="nav-item left-item">
                        <a class="nav-link" href="#">Quản lý mượn trả</a>
                    </li>
                    <li class="nav-item left-item">
                        <a class="nav-link" href="#">Quản lý thông báo</a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto infomation-admin">
                    <li class="nav-item">
                        <a class="nav-link admin-name" href="#">Foo</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle admin-name" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Admin
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Action</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Log Out</a>
                        </div>
                    </li>
                </ul>

            </div>
        </nav>
        <!--Body-Content-->
        <div class = "main-body">
          <!-- this is header of book management -->
            <div class = "header-adminBook">
                <h2>Thêm danh mục</h2>
            </div>
          <form id = "validate-insert-other" action = "insert" method="POST">
                <div class = "insert-book-other">
                    <div class = "insert-book-other-item form-group">
                        <label for="bookname" class="mr-sm-2">Tên Danh Mục</label>
                        <input type="text" class="form-control" name ="categoryName" placeholder="Nhập vào tên danh mục mà bạn muốn thêm" >
                    </div>
                    <div class = "insert-book-other-button">
                        <button id = "btn-Save" class="btn btn-success" type="submit">Thêm Sách</button>
                        <span class = "message-error-book">${requestScope.message_ExistCategoryName}</span>
                    </div>
                </div>             
           </form>
            <!-- show book table - and delete update -->
            <div class="book-table">
             <table class="table table-hover">
                <thead>
                    <tr class = "bg-warning">
                        <th scope="col">Mã</th>
                        <th scope="col">Tên Sách</th>
                        <th scope="col">Xóa</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.categories}" var="c"> 
                    <tr>
                        <th scope="row">${c.id}</th>
                        <td>${c.name}</td>
                        <td>
                            <button type="button" onclick="deleteCategory(${c.id})" class="btn btn-info">Xóa</button>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
              </table>
            </div>
            <!-- This is pagination -->
            <div class = "books-pagination">
                <ul class="pagination" id = "paggerBottom">

                </ul>
            </div>
        </div>
        <script>
            function deleteCategory(cid){
                var c = confirm("Bạn có chắc muốn xóa danh mục này không ?");
                if(c){
                   window.location.href = "delete?pid=" + cid;
                } 
            }
             // có sách mới phân trang 
            if(${requestScope.categories.size() > 0}){
               pagger_Books("paggerBottom",2,${requestScope.totalPage},${requestScope.pageIndex},'${requestScope.url}'); 
            }
             $('#validate-insert-other').validate({
               rules:{
                   categoryName :{
                        required:true
                   }
               },
               messages:{
                   categoryName : {
                       required:"Tên danh mục không được bỏ trống"
                   }
                }
              });
        </script>
    </body>
</html>

