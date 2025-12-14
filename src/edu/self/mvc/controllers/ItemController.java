/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.self.mvc.controllers;
import edu.self.mvc.dto.ItemDto;
import edu.self.mvc.models.ItemModel;
/**
 *
 * @author Anjana Lakshan
 */
public class ItemController {
    ItemModel itemModel = new ItemModel();
    
    public String saveItem(ItemDto itemDto)throws Exception{
        return itemModel.saveItem(itemDto);
    }
}
