/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.self.mvc.models;

import edu.self.mvc.dto.OrderDetailDto;
import edu.self.mvc.dto.OrderDto;
import java.util.ArrayList;
import edu.self.mvc.db.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Anjana Lakshan
 */
public class OrderModel {
    public String placeOrder(OrderDto orderDto,ArrayList<OrderDetailDto>orderDetailDtos) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        
        try{
            connection.setAutoCommit(false);
            String orderSaveSql = "Insert into orders values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(orderSaveSql);
            preparedStatement.setString(1, orderDto.getOrderId());
            preparedStatement.setString(2, orderDto.getOrderDate());
            preparedStatement.setString(3, orderDto.getCustId());
            
            boolean isOrderSaved = preparedStatement.executeUpdate() > 0;
            
            if(isOrderSaved){
                boolean isOrderDetailSaved = true;
                String orderDetailSaveSql = "Insert into orderdetail values(?,?,?,?)";
                
                for(OrderDetailDto orderDetailDto : orderDetailDtos){    
                    PreparedStatement orderDetailStatment = connection.prepareStatement(orderDetailSaveSql);
                    orderDetailStatment.setString(1, orderDto.getOrderId());
                    orderDetailStatment.setString(2, orderDetailDto.getItemCode());
                    orderDetailStatment.setInt(3, orderDetailDto.getQty());
                    orderDetailStatment.setInt(4, orderDetailDto.getDiscount());
                    
                    if(!(orderDetailStatment.executeUpdate() > 0)){
                        isOrderDetailSaved = false;
                    }
                }    
                    if(isOrderDetailSaved){
                        boolean isItemUpdated = true;
                        String itemUpdateSql = "Update item set QtyOnHand = QtyOnHand - ? where ItemCode = ?";
                        
                        for(OrderDetailDto orderDetailDto : orderDetailDtos){
                            PreparedStatement itemUpdateStatement = connection.prepareStatement(itemUpdateSql);
                            itemUpdateStatement.setInt(1,orderDetailDto.getQty());
                            itemUpdateStatement.setString(2,orderDetailDto.getItemCode());
                            
                            if(!(itemUpdateStatement.executeUpdate()>0)){
                                isItemUpdated = false;
                            }
                        }
                        if(isItemUpdated){
                            connection.commit();
                            return "Order Place Success";
                        }else{
                            connection.rollback();
                            return "Item Update Error";
                        }                      
                    }else{
                        connection.rollback();
                        return "Order Detail Save Error";
                    }
            }else{
                connection.rollback();
                return "Order Save Error";
            }
        }catch(Exception e){
            connection.rollback();
            return "Order Save Error";
        }finally{
            connection.setAutoCommit(true);
        }
    }
}
