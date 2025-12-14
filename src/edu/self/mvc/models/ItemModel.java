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
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
    public String updateItem(ItemDto itemDto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE item SET Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? where ItemCode = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,itemDto.getDesc());
        statement.setString(2,itemDto.getPack());
        statement.setDouble(3,itemDto.getUnitPrice());
        statement.setInt(4,itemDto.getQoh());
        statement.setString(5,itemDto.getId());
        
        return statement.executeUpdate()>0 ? "Update data successfully" : "Fail";
    }
    
    public String deleteItem(String itemCode) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM item WHERE ItemCode = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,itemCode);
        
        return statement.executeUpdate() > 0 ? "Delete data successfully" : "Fail";
    }
    
    public ItemDto getItem(String itemCode) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item WHERE ItemCode = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,itemCode);
        ResultSet rst = statement.executeQuery();
        
        if(rst.next()){
            ItemDto itemDto = new ItemDto(
                    rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"),
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand")
            );
            return itemDto;
        }
        return null;
    }
    
    public ArrayList<ItemDto> getAll() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rst = statement.executeQuery();
        ArrayList <ItemDto> itemDtos = new ArrayList<>();
        
        while(rst.next()){
                    ItemDto itemDto = new ItemDto(
                    rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"),
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand")
            );
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }
}