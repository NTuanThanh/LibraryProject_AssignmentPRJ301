package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <link href=\"../css/stylehome.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Thư viện</title>        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--this is header-->\n");
      out.write("        <header>\n");
      out.write("            <div class = \"container-fluid\">\n");
      out.write("                <div class = \"row\">\n");
      out.write("                    <div class =\"col-md-7\">\n");
      out.write("                        <img src=\"../images/logo_main.png\" alt=\"Trường THPT Nghi lộc 4\" width = \"100px\"/>\n");
      out.write("                        <span class = \"name-banner\">THƯ VIỆN XANH - KHO TÀNG SÁCH</span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class =\"col-md-5\">\n");
      out.write("                        <ul class=\"nav\">\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                              <a class=\"nav-link\" href=\"#\">Thông tin mượn sách</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                              <a class=\"nav-link\" href=\"#\">Thông tin cá nhân</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item\">\n");
      out.write("                              <a class=\"nav-link\" href=\"#\">Logout</a>\n");
      out.write("                            </li>\n");
      out.write("                      </ul>\n");
      out.write("                    </div>  \n");
      out.write("                </div> \n");
      out.write("                <div class = \"row header-second\">\n");
      out.write("                    <div class = \"col-md-6\">\n");
      out.write("                        <ul class=\"nav\">\n");
      out.write("                           <li class=\"nav-item color-menu\">\n");
      out.write("                             <a class=\"nav-link\" href=\"#\">Trang chủ</a>\n");
      out.write("                           </li>\n");
      out.write("                           <li class=\"nav-item color-menu\">\n");
      out.write("                             <a class=\"nav-link\" href=\"#\">Thông báo</a>\n");
      out.write("                           </li>\n");
      out.write("                           <li class=\"nav-item color-menu\">\n");
      out.write("                             <a class=\"nav-link\" href=\"#\">Kho sách</a>\n");
      out.write("                           </li>\n");
      out.write("                           <li class=\"nav-item color-menu\">\n");
      out.write("                             <a class=\"nav-link\" href=\"#\">Góc thảo luận</a>\n");
      out.write("                           </li>\n");
      out.write("                           <li class=\"nav-item color-menu\">\n");
      out.write("                             <a class=\"nav-link\" href=\"#\">Hướng dẫn mượn sách</a>\n");
      out.write("                           </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <!--Search function-->\n");
      out.write("                    <div class = \"col-md-3\">                           \n");
      out.write("                        <div class=\"dropdown\">\n");
      out.write("                            <button type=\"button\" class=\"btn btn-success btn-block dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                Danh Mục Sách\n");
      out.write("                            </button>\n");
      out.write("                            <div class=\"dropdown-menu btn-block\">\n");
      out.write("                                ");
for(int i = 0; i < 15; i++){ 
      out.write("\n");
      out.write("                                   <a class=\"dropdown-item\" href=\"#\">Link 1</a>\n");
      out.write("                                ");
}
                                
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div> \n");
      out.write("                    <div class = \"col-md-3 search-header\">\n");
      out.write("                        <form action=\"\">\n");
      out.write("                           <input class = \"input-search\" type=\"text\" placeholder = \"Sách cần tìm...\" name = \"search_book\"/>\n");
      out.write("                           <input class = \"buttom-search\" type = \"submit\" value = \"Tìm\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("    <marquee width=\"60%\" direction=\"left\" height=\"50px\" scrollamount=\"4\">\n");
      out.write("        <span>Trường THPT Nghi Lộc 4 xin thông báo ngày 28/02/2022 còn 50 lượt mượn sách</span>\n");
      out.write("        <span class = \"notice-covid\"> -  HỌC SINH PHẢI CHẤP HÀNH THỰC HIỆN QUY ĐỊNH 5K ĐẢM BẢO AN TOÀN PHÒNG CHỐNG DỊCH COVID-19 KHI QUAY TRỞ LẠI TRƯỜNG VÀ MƯỢN SÁCH</span>\n");
      out.write("    </marquee>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
