<%-- 
    Document   : homeAdmin
    Created on : Mar 14, 2022, 7:03:44 PM
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
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="../css/admin/booksAdmin.css" rel="stylesheet" type="text/css"/>
        <script src="../js/pagination/pagger.js" type="text/javascript"></script>
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
                        <a class="nav-link" href="../home"><i style="margin-right: 5px" class="fa fa-home"></i>Về Trang Chủ User</a>
                    </li>
                    <li class="nav-item left-item">
                        <a class="nav-link" href="books"><i style="margin-right: 5px" class="fa fa-book"></i>Quản Lý Sách</a>
                    </li>
                    <li class="nav-item left-item">
                        <a class="nav-link" href="#">Danh Mục Sách</a>
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
                <h2>Quản Lý Sách</h2>
                <button class="btn btn-warning" onclick = "insertBook()" type="submit">+ Thêm Sách</button>
            </div>
          <!-- advanced search -->
            <form action = "books" method="GET">
                <div class="advanced-search">
                    <div class = "advanced-search-item">
                        <label for="category">Theo Danh Mục</label>
                        <select class="form-control" id="category" name = "cid">
                            <option value>Chọn Tên Danh Mục</option>
                            <c:forEach items = "${requestScope.categories}" var = "c">
                                <option ${requestScope.cid == c.id?"selected = selected":""} value = "${c.id}">${c.name}</option>
                            </c:forEach>                                        
                        </select>
                    </div>
                    <div class = "advanced-search-item">
                        <label for="publisher">Theo Nhà Xuất Bản</label>
                        <select class="form-control" id="publisher" name = "pid">
                            <option value>Chọn Tên Nhà Xuất Bản</option>
                            <c:forEach items = "${requestScope.publishers}" var = "p">
                                <option ${requestScope.pid == p.id?"selected = selected":""} value = "${p.id}">${p.name}</option>
                            </c:forEach>                                        
                        </select>
                    </div>
                    <div class = "advanced-search-item">
                        <label for="publication_from">Xuất Bản Từ Năm</label>
                        <select class="form-control" id="publication_from" name = "from">
                            <option value>Chọn Năm Bắt Đầu Từ</option>
                            <c:forEach items = "${requestScope.publicationYears}" var = "y">
                                <option ${requestScope.from == y?"selected = selected":""} value = "${y}">${y}</option>
                            </c:forEach>                                        
                        </select>
                    </div>
                    <div class = "advanced-search-item">
                        <label for="publication_to">Đến Năm</label>
                        <select class="form-control" id="publication_to" name = "to">
                            <option value>Chọn Năm Kết Thúc</option>
                            <c:forEach items = "${requestScope.publicationYears}" var = "y">
                                <option ${requestScope.to == y?"selected = selected":""} value = "${y}">${y}</option>
                            </c:forEach>                                        
                        </select>
                    </div>
                    <div class = "advanced-search-item second">
                        <label for="bookname" class="mr-sm-2">Tên Sách</label>
                        <input value="${requestScope.bname}" type="text" class="form-control" name ="bname"  id="bookname" placeholder="Nhập vào tên sách" >
                    </div>
                    <div class = "advanced-search-item second">
                        <label for="author" class="mr-sm-2">Tên Tác Giả</label>
                        <input value="${requestScope.author}" type="text" class="form-control" name ="author" id="author" placeholder="Nhập vào tên tác giả" >
                    </div>
                </div>
                <div class = "advanced-search-submit">
                    <button class="btn btn-danger" type="submit">Tìm Kiếm</button>
                </div>
            </form>
            <!-- show book table - and delete update -->
            <div class="book-table">
             <table class="table table-hover">
                <thead>
                    <tr class = "bg-warning">
                        <th scope="col">Mã</th>
                        <th scope="col">Tên Sách</th>
                        <th scope="col">Tác Giả</th>
                        <th scope="col">Thể Loại</th>
                        <th scope="col">Nhà Xuất Bản</th>
                        <th scope="col">Năm</th>
                        <th scope="col">Sửa</th>
                        <th scope="col">Xóa</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.books}" var="b"> 
                    <tr>
                        <th scope="row">${b.id}</th>
                        <td>${b.name}</th>
                        <td>${b.author}</th>
                        <td>${b.category.name}</th>
                        <td>${b.publisher.name}</th>
                        <td>${b.publicationYear}</th>
                        <td><button type="button" onclick="updateBook(${b.id})" class="btn btn-info">Sửa</button></th>
                        <td>
                            <button type="button" class="btn btn-info" data-toggle="modal" data-target="#exampleModal">
                                Xóa
                            </button>
                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Bạn có chắc muốn xóa quyển sách này ?</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                            <button type="button" onclick = "deleteBook(${b.id})" class="btn btn-primary">Xóa</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
            // có sách mới phân trang 
            if(${requestScope.books.size() > 0}){
               pagger_Books("paggerBottom",2,${requestScope.totalPage},${requestScope.pageIndex},'${requestScope.url}'); 
            }
            function insertBook(){
                window.location.href = "books/insert"; 
            }
            function updateBook(id){
                window.location.href = "books/update?bid="+id;
            }
            function deleteBook(id){
                window.location.href = "books/delete?bid=" + id;  
            }
        </script>
    </body>
</html>
