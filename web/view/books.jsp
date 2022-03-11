<%-- 
    Document   : books.jsp
    Created on : Mar 6, 2022, 8:45:04 PM
    Author     : pv
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modal.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kho sách - Thư viện</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="css/stylehome.css" rel="stylesheet" type="text/css"/>     
        <link href="css/books.css" rel="stylesheet" type="text/css"/>
        <c:set var = "now" value = "<%= new java.util.Date()%>" />
    </head>
    <body>
        <!--this is header-->
        <header>
            <div class = "container-fluid">
                <div class = "row">
                    <div class ="col-md-7">
                        <img src="images/logo_main.png" alt="Trường THPT Nghi lộc 4" width = "100px"/>
                        <span class = "name-banner">THƯ VIỆN XANH - KHO TÀNG SÁCH</span>
                    </div>
                    <div class ="col-md-5">
                        <ul class="nav">
                            <li class="nav-item">
                              <a class="nav-link" href="#">Thông tin mượn sách</a>
                            </li>
                            <li class="nav-item">
                              <a class="nav-link" href="#">Thông tin cá nhân</a>
                            </li>
                            <li class="nav-item">
                              <a class="nav-link" href="#">Logout</a>
                            </li>
                      </ul>
                    </div>  
                </div> 
                <div class = "row header-second">
                    <div class = "col-md-12">
                        <nav class="navbar navbar-expand-lg navbar-light">
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                                <ul class="navbar-nav mr-auto">
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="home">Trang chủ</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="#">Thông báo</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="books">Kho sách</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="#">Góc thảo luận</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="#">Hướng dẫn mượn sách</a>
                                    </li>      
                                </ul>
                                <div class="dropdown mr-auto">
                                    <button type="button" class="my-size-category btn btn-success btn-block dropdown-toggle" data-toggle="dropdown">
                                        Danh Mục Sách
                                    </button>
                                    <div class="dropdown-menu btn-block">
                                        <c:forEach items="${requestScope.categories}" var ="c">
                                          <a class="dropdown-item" href="#">${c.name}</a>      
                                        </c:forEach>
                                    </div>
                                </div>            
                                <form class="form-inline" action = "">
                                    <input class="form-control mr-sm-2" type="search" placeholder="Sách cần tìm...">
                                    <button class="btn btn-warning" type="submit">Tìm Kiếm</button>
                                </form>          
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <!--notification-->
        <marquee width="60%" direction="left" height="50px" scrollamount="4">
            <span>Trường THPT Nghi Lộc 4 xin thông báo ngày 
                           <fmt:formatDate type = "date" 
                            value = "${now}" /> 
                  còn 50 lượt mượn sách
            </span>
            <span class = "notice-covid"> -  HỌC SINH PHẢI CHẤP HÀNH THỰC HIỆN QUY ĐỊNH 5K ĐẢM BẢO AN TOÀN PHÒNG CHỐNG DỊCH COVID-19 KHI QUAY TRỞ LẠI TRƯỜNG VÀ MƯỢN SÁCH</span>
        </marquee>
        <!-- Body -->
        <div class = "main-body">
            <div class = "row row-body-flex">
                <!-- this is left body -->
                <div class = "col-lg-9">
                    <div class = "block-books-left">
                        <div class="sidebar-title">Tìm kiếm nâng cao</div>
                        <!-- Advanced Search-->
                        <form>
                            <div class="advanced-search">
                                <div class = "advanced-search-item category">
                                    <label for="category">Theo Danh Mục</label>
                                    <select class="form-control" id="category">
                                        <option>Chọn Tên Danh Mục</option>
                                        <c:forEach items = "${requestScope.categories}" var = "c">
                                            <option>${c.name}</option>
                                        </c:forEach>>                                        
                                    </select>
                                </div>
                                <div class = "advanced-search-item">
                                    <label for="title" class="mr-sm-2">Tên Sách</label>
                                    <input type="text" class="form-control" id="title" placeholder="Nhập vào tên sách" >
                                </div>
                                <div class = "advanced-search-item">
                                   <label for="author" class="mr-sm-2">Tên Tác Giả</label>
                                   <input type="text" class="form-control" id="author" placeholder="Nhập vào tên tác giả" >
                                </div>
                                <div class = "advanced-search-item">
                                   <label for="author" class="mr-sm-2">Tên Nhà Xuất Bản</label>
                                   <input type="text" class="form-control" id="author" placeholder="Nhập vào nhà xuất bản" >
                                </div>
                            </div>
                            <div class = "advanced-search-submit">
                                <button class="btn btn-danger" type="submit">Tìm Kiếm</button>
                            </div>
                        </form>
                        <!--Show all books -->
                        <!--Pagination -->
                        <!-- This is pagination -->
                        <div class = "books-pagination">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link" href="#">First</a></li>
                                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                <li class="page-item"><a class="page-link" href="#">Last</a></li>
                            </ul>
                        </div>
                        <!--Show books-->
                        <div class = "books-item">                   
                            <c:forEach items="${requestScope.top10books}" var = "b">
                               <a href ="books/details?book-id=${b.id}" class = "book-item">
                                <figure>
                                   <img src="images/books/${b.img}" alt="${b.name}"/>
                                </figure>                           
                                <div class = "book-info">
                                    <p class = "book-title">${b.name}</p>
                                    <h3 class = "book-category">${b.category.name}</h3>
                                    <p class = "book-author">${b.author}</p>
                                </div>
                               </a>
                            </c:forEach>
                        </div>
                        <!-- This is pagination -->
                        <div class = "books-pagination">
                            <ul class="pagination" id = "viewPagger">
                                <li class="page-item"><a class="page-link" href="#">First</a></li>
                                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                <li class="page-item"><a class="page-link" href="#">Last</a></li>
                            </ul>
                        </div>
                    </div>    
                </div>
                <!-- this is right body -->
                <div class = "col-lg-3">
                    <div class = "block-categories-right">
                        <div class="sidebar-title">Danh Mục</div>
                        <ul class="list-group list-group-flush">
                            <c:forEach items="${requestScope.categories}" var ="c">
                                 <li class="list-group-item">
                                    <a href="#">${c.name}</a>
                                 </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                
            </div>
        </div>
        <!-- Footer -->
       <footer class="main-footer">
            <div class = "text-center">
                <p><strong>Thư viện Trường THPT Nghi Lộc 4</strong></p>
                <p>Địa chỉ : Xóm 2, Nghi Xá, Nghi Lộc, Nghệ An</p>
                <p>Điện Thoại : 02383 861 079</p>
                <p>Email :
                    <a href="mailto:thuviennghiloc4@nghean.edu.vn">thuviennghiloc4@nghean.edu.vn</a>
                </p>
            </div>
            <div class="footer-copyright text-center py-3">© 2022 Copyright:
                <a href="#"> thuviennghiloc4.edu.vn</a>
            </div>
        </footer>
        
    </body>
</html>
