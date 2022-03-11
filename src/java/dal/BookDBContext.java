/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.Book;
import modal.Category;
import modal.Language;
import modal.Publisher;

/**
 *
 * @author pv
 */
public class BookDBContext extends DBContext{
    public void insert(Book b){
        try {
            String sql = "INSERT INTO [Book]\n" +
                        "           ([name]\n" +
                        "           ,[publication_year]\n" +
                        "           ,[number_pages]\n" +
                        "           ,[img]\n" +
                        "           ,[Description]\n" +
                        "           ,[author]\n" +
                        "           ,[publisher_id]\n" +
                        "           ,[language_id]\n" +
                        "           ,[location]\n" +
                        "           ,[category_id])\n" +
                        "     VALUES\n" +
                        "           (?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?)"; 
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, b.getName());
            stm.setInt(2, b.getPublicationYear());
            stm.setInt(3, b.getNumberPages());
            stm.setString(4, b.getImg());
            stm.setString(5, b.getDescription());
            stm.setString(6, b.getAuthor());
            stm.setInt(7, b.getPublisher().getId());
            stm.setInt(8, b.getLanguage().getId());
            stm.setString(9, b.getLocation());
            stm.setInt(10, b.getCategory().getId());
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(BookDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    public ArrayList<Book> getTop10books(){
        ArrayList<Book> top10books = new ArrayList<>(); 
        try {
            String sql = "select top(10) book_id, b.[name] as bname, publication_year, number_pages, img, [Description], author, \n" +
                        "                 p.publisher_id, p.[name] as pname, l.language_id, l.name_language as lname, c.category_id, c.[name] as cname, [location] \n" +
                        "from Book as b inner join Publisher as p on b.publisher_id = p.publisher_id \n" +
                        "               inner join Categories as c on b.category_id = c.category_id\n" +
                        "		inner join [Language] as l on b.language_id = l.language_id\n" +
                        "order by b.book_id desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Book book = new Book(); 
                book.setId(rs.getInt("book_id"));
                book.setName(rs.getString("bname"));
                book.setPublicationYear(rs.getInt("publication_year"));
                book.setNumberPages(rs.getInt("number_pages"));
                book.setImg(rs.getString("img"));
                book.setDescription(rs.getString("Description"));
                book.setAuthor(rs.getString("author"));
                Publisher p = new Publisher(); 
                p.setId(rs.getInt("publisher_id"));
                p.setName(rs.getString("pname"));
                book.setPublisher(p);
                Category c = new Category();
                c.setId(rs.getInt("category_id"));
                c.setName(rs.getString("cname"));
                book.setCategory(c);
                Language l = new Language(); 
                l.setId(rs.getInt("language_id"));
                l.setName(rs.getString("lname"));
                book.setLanguage(l);
                book.setLocation(rs.getString("location"));
                top10books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return top10books;
    }
}
