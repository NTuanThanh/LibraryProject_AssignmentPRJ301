/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.Publisher;

/**
 *
 * @author pv
 */
public class PublisherDBContext extends DBContext{
   public void insert(Publisher p){
        PreparedStatement stm = null;
        try {
            String sql = "INSERT INTO [Publisher]\n" +
                    "           ([name])\n" +
                    "     VALUES\n" +
                    "           (?)";
            stm = connection.prepareStatement(sql); 
            stm.setString(1, p.getName());
            stm.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(stm != null){
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }if(connection != null){
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }    
    }
   public boolean checkExistPname(String pname){
        try {
            String sql = "select [name] from Publisher where [name] like ?"; 
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, pname);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;       
    }
}
