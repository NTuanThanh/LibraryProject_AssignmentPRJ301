/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.Book;

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
}
