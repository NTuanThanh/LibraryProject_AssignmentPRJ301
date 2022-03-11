/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dal.PublisherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Publisher;

/**
 *
 * @author pv
 */
public class InsertPublisher extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển đến trang insert category
        request.getRequestDispatcher("../../view/admin/insertPublisher.jsp").forward(request, response);        
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
        request.setCharacterEncoding("UTF-8");
        PublisherDBContext publisherDB = new PublisherDBContext();
        String publisherName = request.getParameter("publisherName");
        // kiểm tra tên danh mục sách vừa nhập đã tồn tại trong dbi chưa
        boolean checkExistCname = publisherDB.checkExistPname(publisherName);
        // nếu không thì tiếp tục vào InsertCategory để insert vào dbi
        if(publisherName != null || publisherName.trim().length() > 0){
            // nếu có thì chuyển lại trang insert và thông báo message là đã có
            if (checkExistCname == true) {
                request.setAttribute("message_ExistPublisherName", "Nhà Xuất Bản Này Đã Tồn Tại");
                request.getRequestDispatcher("../../view/admin/insertPublisher.jsp").forward(request, response);
            }else{
                Publisher p = new Publisher();
                p.setName(publisherName);
                publisherDB.insert(p);
            }
        }
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
