package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class books_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Kho sách - Thư viện</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <link href=\"css/stylehome.css\" rel=\"stylesheet\" type=\"text/css\"/>      \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--this is header-->\n");
      out.write("        <header>\n");
      out.write("            <div class = \"container-fluid\">\n");
      out.write("                <div class = \"row\">\n");
      out.write("                    <div class =\"col-md-7\">\n");
      out.write("                        <img src=\"images/logo_main.png\" alt=\"Trường THPT Nghi lộc 4\" width = \"100px\"/>\n");
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
      out.write("                    <div class = \"col-md-12\">\n");
      out.write("                        <nav class=\"navbar navbar-expand-lg navbar-light\">\n");
      out.write("                            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#collapsibleNavbar\">\n");
      out.write("                                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                            </button>\n");
      out.write("                            <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\n");
      out.write("                                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                                    <li class=\"nav-item color-menu\">\n");
      out.write("                                        <a class=\"nav-link\" href=\"#\">Trang chủ</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item color-menu\">\n");
      out.write("                                        <a class=\"nav-link\" href=\"#\">Thông báo</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item color-menu\">\n");
      out.write("                                        <a class=\"nav-link\" href=\"#\">Kho sách</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item color-menu\">\n");
      out.write("                                        <a class=\"nav-link\" href=\"#\">Góc thảo luận</a>\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class=\"nav-item color-menu\">\n");
      out.write("                                        <a class=\"nav-link\" href=\"#\">Hướng dẫn mượn sách</a>\n");
      out.write("                                    </li>      \n");
      out.write("                                </ul>\n");
      out.write("                                <div class=\"dropdown mr-auto\">\n");
      out.write("                                    <button type=\"button\" class=\"my-size-category btn btn-success btn-block dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                        Danh Mục Sách\n");
      out.write("                                    </button>\n");
      out.write("                                    <div class=\"dropdown-menu btn-block\">\n");
      out.write("                                        <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.categories}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var =\"c\">\n");
      out.write("                                          <a class=\"dropdown-item\" href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>      \n");
      out.write("                                        </c:forEach>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>            \n");
      out.write("                                <form class=\"form-inline\" action = \"\">\n");
      out.write("                                    <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Sách cần tìm...\">\n");
      out.write("                                    <button class=\"btn btn-warning\" type=\"submit\">Tìm Kiếm</button>\n");
      out.write("                                </form>          \n");
      out.write("                            </div>\n");
      out.write("                        </nav>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <!--notification-->\n");
      out.write("        <marquee width=\"60%\" direction=\"left\" height=\"50px\" scrollamount=\"4\">\n");
      out.write("            <span>Trường THPT Nghi Lộc 4 xin thông báo ngày \n");
      out.write("                           <fmt:formatDate type = \"date\" \n");
      out.write("                            value = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${now}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" /> \n");
      out.write("                  còn 50 lượt mượn sách\n");
      out.write("            </span>\n");
      out.write("            <span class = \"notice-covid\"> -  HỌC SINH PHẢI CHẤP HÀNH THỰC HIỆN QUY ĐỊNH 5K ĐẢM BẢO AN TOÀN PHÒNG CHỐNG DỊCH COVID-19 KHI QUAY TRỞ LẠI TRƯỜNG VÀ MƯỢN SÁCH</span>\n");
      out.write("        </marquee>       \n");
      out.write("        <!-- Footer -->\n");
      out.write("       <footer class=\"main-footer\">\n");
      out.write("            <div class = \"text-center\">\n");
      out.write("                <p><strong>Thư viện Trường THPT Nghi Lộc 4</strong></p>\n");
      out.write("                <p>Địa chỉ : Xóm 2, Nghi Xá, Nghi Lộc, Nghệ An</p>\n");
      out.write("                <p>Điện Thoại : 02383 861 079</p>\n");
      out.write("                <p>Email :\n");
      out.write("                    <a href=\"mailto:thuviennghiloc4@nghean.edu.vn\">thuviennghiloc4@nghean.edu.vn</a>\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"footer-copyright text-center py-3\">© 2022 Copyright:\n");
      out.write("                <a href=\"#\"> thuviennghiloc4.edu.vn</a>\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("        \n");
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
