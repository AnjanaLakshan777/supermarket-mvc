/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.self.mvc.models;
import edu.self.mvc.dto.ItemDto;
import java.sql.Connection;
import edu.self.mvc.db.DBConnection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author Anjana Lakshan
 */
public class ItemModel {
    public String saveItem(ItemDto itemDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO item VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,itemDto.getId());
        statement.setString(2,itemDto.getDesc());
        statement.setString(3,itemDto.getPack());
        statement.setDouble(4,itemDto.getUnitPrice());
        statement.setInt(5,itemDto.getQoh());
        
        return statement.executeUpdate() > 0 ? "Insert data successfully" : "Fail";
    }
}
