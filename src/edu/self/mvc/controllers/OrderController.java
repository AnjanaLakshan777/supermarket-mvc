/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.self.mvc.controllers;
import edu.self.mvc.dto.OrderDto;
import edu.self.mvc.dto.OrderDetailDto;
import java.util.ArrayList;
import edu.self.mvc.models.OrderModel;
import java.sql.SQLException;
/**
 *
 * @author Anjana Lakshan
 */
public class OrderController { 
    private OrderModel orderModel = new OrderModel();
    public String placeOrder(OrderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos) throws ClassNotFoundException, SQLException{
        return orderModel.placeOrder(orderDto, orderDetailDtos);
    }
}
