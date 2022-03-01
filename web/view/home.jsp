<%-- 
    Document   : home
    Created on : Feb 27, 2022, 2:42:29 PM
    Author     : pv
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modal.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="css/stylehome.css" rel="stylesheet" type="text/css"/>
        <title>Thư viện</title>
        <%
           ArrayList<Category> categories = (ArrayList<Category>)request.getAttribute("categories"); 
        %>        
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
                                        <a class="nav-link" href="#">Trang chủ</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="#">Thông báo</a>
                                    </li>
                                    <li class="nav-item color-menu">
                                        <a class="nav-link" href="#">Kho sách</a>
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
                                        <%for (Category c : categories) {%>
                                        <a class="dropdown-item" href="#"><%= c.getName()%></a>      
                                        <%}
                                        %>
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
    <marquee width="60%" direction="left" height="50px" scrollamount="4">
        <span>Trường THPT Nghi Lộc 4 xin thông báo ngày 28/02/2022 còn 50 lượt mượn sách</span>
        <span class = "notice-covid"> -  HỌC SINH PHẢI CHẤP HÀNH THỰC HIỆN QUY ĐỊNH 5K ĐẢM BẢO AN TOÀN PHÒNG CHỐNG DỊCH COVID-19 KHI QUAY TRỞ LẠI TRƯỜNG VÀ MƯỢN SÁCH</span>
    </marquee>
    </body>
</html>
