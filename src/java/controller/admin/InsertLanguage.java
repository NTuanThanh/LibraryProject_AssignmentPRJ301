/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dal.LanguageDBContext;
import dal.PublisherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modal.Language;
import modal.Publisher;

/**
 *
 * @author pv
 */
public class InsertLanguage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("../../view/admin/insertLanguage.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        LanguageDBContext languageDB = new LanguageDBContext(); 
        String languageName = request.getParameter("languageName");
        // kiểm tra tên danh mục sách vừa nhập đã tồn tại trong dbi chưa
        boolean checkExistLname = languageDB.checkExistLname(languageName);
        // nếu không thì tiếp tục vào InsertCategory để insert vào dbi
        if(languageName != null || languageName.trim().length() > 0){
            // nếu có thì chuyển lại trang insert và thông báo message là đã có
            if (checkExistLname == true) {
                request.setAttribute("message_ExistCategoryName", "Tên ngôn ngữ này đã tồn tại");
                request.getRequestDispatcher("../../view/admin/insertLanguage.jsp").forward(request, response);
            }else{
                Language l = new Language(); 
                l.setName(languageName);
                languageDB.insert(l);
            }
        }
    }
}
