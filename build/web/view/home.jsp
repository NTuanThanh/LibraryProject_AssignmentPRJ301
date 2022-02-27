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
            <div class = "container">
            <div class = "row">
                <div class ="col-md-7">
                    <img src="../images/logo_main.png" alt="Trường THPT Nghi lộc 4" width = "100px"/>
                    <span>THƯ VIỆN XANH - KHO TÀNG SÁCH</span>
                </div>
                <div class ="col-md-5">
                    <ul class="nav">
                        <li class="nav-item active">
                          <a class="nav-link" href="#">Thông tin mượn sách</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">Thông tin cá nhân</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">Logout</a>
                        </li>
                  </ul>
                </ul>
                </div>
            </div> 
            <div class = "row">
                <div class = "col-md-8">
                    <ul class="nav">
                        <li class="nav-item">
                          <a class="nav-link" href="#">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">Thông báo</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">Góc thảo luận</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">Hướng dẫn mượn sách</a>
                        </li>
                    </ul>
                </div>
                 <div class = "col-md-4">
                     <form action="">
                        <input type="text" placeholder = "Sách Cần Tìm..." name = "search_book"/>
                        <input type = "submit" value = "search">
                     </form>
                </div>
            </div>
            </div>
        </header>       
    </body>
</html>
