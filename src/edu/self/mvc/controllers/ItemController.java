/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.self.mvc.controllers;
import edu.self.mvc.dto.ItemDto;
import edu.self.mvc.models.ItemModel;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Anjana Lakshan
 */
public class ItemController {
    private ItemModel itemModel = new ItemModel();
    
    public String saveItem(ItemDto itemDto)throws ClassNotFoundException, SQLException{
        return itemModel.saveItem(itemDto);
    }
    public String updateItem(ItemDto itemDto) throws ClassNotFoundException, SQLException{
        return itemModel.updateItem(itemDto);
    } 
    public String deleteItem(String itemCode) throws ClassNotFoundException, SQLException{
        return itemModel.deleteItem(itemCode);
    } 
    public ItemDto getItem(String itemCode) throws ClassNotFoundException, SQLException{
        return itemModel.getItem(itemCode);
    }
    public ArrayList<ItemDto> getAll() throws ClassNotFoundException, SQLException{
        return itemModel.getAll();
    }
}