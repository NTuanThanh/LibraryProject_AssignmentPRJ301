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
import modal.Category;

/**
 *
 * @author pv
 */
public class CategoryDBContext extends DBContext{
    public ArrayList<Category> getAllCategories(){
        ArrayList<Category> categories = new ArrayList<>(); 
        String sql = "select category_id, [name] from Categories";
        PreparedStatement stm = null; 
        try { 
            stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(); 
            while(rs.next()){
                Category c = new Category(); 
                c.setId(rs.getInt("category_id"));
                c.setName(rs.getString("name"));
                categories.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return categories;
    }
}
