/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.BookDBContext;
import dal.CategoryDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Book;
import modal.Category;

/**
 *
 * @author pv
 */
public class ListAllBooksController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CategoryDBContext categoryDB = new CategoryDBContext();
        BookDBContext bookDB = new BookDBContext(); 
        ArrayList<Category> categories = categoryDB.getAllCategories();
        // phân trang
        int pageSize = 10; 
        String page = request.getParameter("page");
        if(page == null || page.trim().length() == 0){
            page = "1"; 
        }
        int pageIndex = Integer.parseInt(page);
        ArrayList<Book> books = bookDB.getAllBooks(pageIndex, pageSize);
        int count = bookDB.count(); 
        int totalPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize) + 1;
        request.setAttribute("books",books);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("view/books.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
