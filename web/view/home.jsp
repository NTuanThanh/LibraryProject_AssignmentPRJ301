<%-- 
    Document   : home
    Created on : Feb 27, 2022, 2:42:29 PM
    Author     : pv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="../css/stylehome.css" rel="stylesheet" type="text/css"/>
        <title>Thư viện</title>        
    </head>
    <body>
        <!--this is header-->
        <header>
            <div class = "container-fluid">
                <div class = "row">
                    <div class ="col-md-7">
                        <img src="../images/logo_main.png" alt="Trường THPT Nghi lộc 4" width = "100px"/>
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
                    <div class = "col-md-6">
                        <ul class="nav">
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
                    </div>
                    <!--Search function-->
                    <div class = "col-md-3">                           
                        <div class="dropdown">
                            <button type="button" class="btn btn-success btn-block dropdown-toggle" data-toggle="dropdown">
                                Danh Mục Sách
                            </button>
                            <div class="dropdown-menu btn-block">
                                <%for(int i = 0; i < 15; i++){ %>
                                   <a class="dropdown-item" href="#">Link 1</a>
                                <%}
                                %>
                            </div>
                        </div>
                    </div> 
                    <div class = "col-md-3 search-header">
                        <form action="">
                           <input class = "input-search" type="text" placeholder = "Sách cần tìm..." name = "search_book"/>
                           <input class = "buttom-search" type = "submit" value = "Tìm">
                        </form>
                    </div>
                </div>
            </div>
        </header>
    <marquee width="60%" direction="left" height="50px">
        Trường THPT Nghi Lộc 4 xin thông báo ngày 28/02/2022 còn 50 lượt mượn sách
    </marquee>
    </body>
</html>
