/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dal.CategoryDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Category;

/**
 *
 * @author pv
 */
public class InsertCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        int pageSize = 10; 
        String page = request.getParameter("page");
        if(page == null || page.trim().length() == 0){
            page = "1"; 
        }
        CategoryDBContext categoryDB = new CategoryDBContext(); 
        int pageIndex = Integer.parseInt(page);
        ArrayList<Category> categories = categoryDB.getAllCategories(pageIndex, pageSize);
        int count = categoryDB.count();
        int totalPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize) + 1;
        response.getWriter().print(count);
        String url = "insert?";
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("categories", categories);
        request.setAttribute("url",url);
        request.getRequestDispatcher("../../view/admin/insertCategory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CategoryDBContext CategoryDB = new CategoryDBContext();
        String catoryName = request.getParameter("categoryName");
        // kiểm tra tên danh mục sách vừa nhập đã tồn tại trong dbi chưa
        boolean checkExistCname = CategoryDB.checkExistCname(catoryName.trim());
        // nếu không thì tiếp tục vào InsertCategory để insert vào dbi
        if(catoryName != null || catoryName.trim().length() > 0){
            // nếu có thì chuyển lại trang insert và thông báo message là đã có
            if (checkExistCname == true) {
                ArrayList<Category> categories = CategoryDB.getAllCategories();
                request.setAttribute("categories", categories);
                request.setAttribute("message_ExistCategoryName", "Danh mục sách này đã tồn tại");
                request.getRequestDispatcher("../../view/admin/insertCategory.jsp").forward(request, response);
            }else{
                Category c = new Category(); 
                c.setName(catoryName);
                CategoryDB.insert(c);
                response.sendRedirect("insert");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
