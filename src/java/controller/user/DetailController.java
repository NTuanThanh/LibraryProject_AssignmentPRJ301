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
public class DetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        CategoryDBContext categoryDB = new CategoryDBContext();
        BookDBContext bookDB = new BookDBContext();
        ArrayList<Category> categories = categoryDB.getAllCategories();
        String raw_bid = request.getParameter("bid");
        if(raw_bid == null || raw_bid.length() == 0){
            raw_bid = "-1"; 
        }
        int bid = Integer.parseInt(raw_bid); 
        Book book = bookDB.getBook(bid); 
        request.setAttribute("book", book);
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("../view/detail.jsp").forward(request, response);               
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
