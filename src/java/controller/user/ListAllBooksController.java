/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dal.BookDBContext;
import dal.CategoryDBContext;
import dal.PublisherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Book;
import modal.Category;
import modal.Publisher;

/**
 *
 * @author pv
 */
public class ListAllBooksController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        CategoryDBContext categoryDB = new CategoryDBContext();
        BookDBContext bookDB = new BookDBContext();
        PublisherDBContext publisherDB = new PublisherDBContext(); 
        ArrayList<Publisher> publishers = publisherDB.getPublisher();
        ArrayList<Category> categories = categoryDB.getAllCategories();
        // phân trang
        int pageSize = 10; 
        String page = request.getParameter("page");
        if(page == null || page.trim().length() == 0){
            page = "1"; 
        }
        int pageIndex = Integer.parseInt(page);
        if(pageIndex < 1) pageIndex = 1;
        // Searching : 
        //cid=&pid=&from=&to=&bname=&aname=
        String raw_cid = request.getParameter("cid"); 
        String raw_pid = request.getParameter("pid"); 
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        String raw_bname = request.getParameter("bname"); 
        String raw_author = request.getParameter("author"); 
        
        if(raw_cid == null || raw_cid.length() == 0){
           raw_cid = "-1"; 
        }
        if(raw_pid == null || raw_pid.length() == 0){
           raw_pid = "-1"; 
        }
        if(raw_from == null || raw_from.length() == 0){
           raw_from = "-1"; 
        }
        if(raw_to == null || raw_to.length() == 0){
           raw_to = "-1"; 
        }
        if(raw_bname == null || raw_bname.length() == 0){
            raw_bname = null;
        }
        if(raw_author == null || raw_author.length() == 0){
            raw_author = null;
        } 
        int cid = Integer.parseInt(raw_cid); 
        int pid = Integer.parseInt(raw_pid); 
        int from = Integer.parseInt(raw_from); 
        int to = Integer.parseInt(raw_to);
        String bname = raw_bname; 
        String author = raw_author; 

        // Lấy ra book từ những dữ liệu trên 
        ArrayList<Book> books = bookDB.advancedSearch(cid, pid, from, to, bname, author, pageIndex, pageSize);
        int count = bookDB.countAdvanceSearch(cid, pid, from, to, bname, author);
        int totalPage = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize) + 1;
        request.setAttribute("books",books);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("categories", categories);
        request.setAttribute("publishers", publishers);
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
