/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dal.BookDBContext;
import dal.CategoryDBContext;
import dal.LanguageDBContext;
import dal.PublisherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modal.Book;
import modal.Category;
import modal.Language;
import modal.Publisher;

/**
 *
 * @author pv
 */
@MultipartConfig(
        fileSizeThreshold   = 1024 * 1024 * 2,  // 1 MB
        maxFileSize         = 1024 * 1024 * 10, // 10 MB
        maxRequestSize      = 1024 * 1024 * 50, //50 MB
        location = "C:\\Users\\pv\\Desktop\\Assignment PRJ301\\Assignment_Library\\web\\images\\books"// 15 MB
)
public class InsertBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDBContext categoryDB = new CategoryDBContext(); 
        PublisherDBContext publisherDB = new PublisherDBContext();
        LanguageDBContext languageDB = new LanguageDBContext(); 
        ArrayList<Category> categories = categoryDB.getAllCategories();
        ArrayList<Publisher> publishers = publisherDB.getPublisher();
        ArrayList<Language> Languages = languageDB.getLanguages();
        request.setAttribute("categories", categories);
        request.setAttribute("publishers", publishers);
        request.setAttribute("languages", Languages);
        request.getRequestDispatcher("../../view/admin/insertBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("bname"); 
        int publisher_id = Integer.parseInt(request.getParameter("publisher_id")); 
        int category_id = Integer.parseInt(request.getParameter("category_id"));
        String descrip = request.getParameter("descrip"); 
        int publication_year = Integer.parseInt(request.getParameter("publication_year")); 
        int language_id = Integer.parseInt(request.getParameter("language_id")); 
        String author = request.getParameter("author"); 
        int numberPage = Integer.parseInt(request.getParameter("numberpage")); 
        String location = request.getParameter("location"); 
        // xử lý ảnh 
        Part part = request.getPart("img");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        part.write(filename);
//        // insert dữ liệu vào database
//        Book book = new Book();
//        Publisher publisher = new Publisher();
//        publisher.setId(publisher_id);
//        Category category = new Category();
//        category.setId(category_id);
//        Language language = new Language(); 
//        language.setId(language_id);
//        book.setName(name);
//        book.setPublisher(publisher);
//        book.setCategory(category);
//        book.setLanguage(language);
//        book.setDescription(descrip);
//        book.setPublicationYear(publication_year);
//        book.setAuthor(author);
//        book.setNumberPages(numberPage);
//        book.setLocation(location);
//        book.setImg(filename);
//        // insert 
//        BookDBContext bookdb = new BookDBContext(); 
//        bookdb.insert(book);
    }

}
