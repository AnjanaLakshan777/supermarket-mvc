/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.self.mvc.models;

import edu.self.mvc.db.DBConnection;
import edu.self.mvc.dto.CustomerDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anjana Lakshan
 */
public class CustomerModel {
    public String saveCustomer(CustomerDto customerDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,customerDto.getId());
        statement.setString(2,customerDto.getTitle());
        statement.setString(3,customerDto.getName());
        statement.setString(4,customerDto.getDob());
        statement.setString(5,customerDto.getAddress());
        statement.setString(6,customerDto.getCity());
        statement.setString(7,customerDto.getProvince());
        statement.setString(8,customerDto.getPostalCode());
        
        return statement.executeUpdate() > 0 ? "Insert data successfully" : "Fail";
    }
    
    public String updateCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE customer SET CustTitle = ?, CustName = ?, DOB = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ? where CustID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,customerDto.getTitle());
        statement.setString(2,customerDto.getName());
        statement.setString(3,customerDto.getDob());
        statement.setString(4,customerDto.getAddress());
        statement.setString(5,customerDto.getCity());
        statement.setString(6,customerDto.getProvince());
        statement.setString(7,customerDto.getPostalCode());
        statement.setString(8,customerDto.getId());
        
        return statement.executeUpdate()>0 ? "Update data successfully" : "Fail";
    }
    
    public String deleteCustomer(String customerId) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM customer WHERE CustID = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,customerId);
        
        return statement.executeUpdate() > 0 ? "Delete data successfully" : "Fail";
    }
    
    public CustomerDto getCustomer(String customerId) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer WHERE CustID = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,customerId);
        ResultSet rst = statement.executeQuery();
        
        if(rst.next()){
            CustomerDto customerDto = new CustomerDto(
                    rst.getString("CustID"),
                    rst.getString("CustTitle"),
                    rst.getString("CustName"),
                    rst.getString("DOB"),
                    rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"),
                    rst.getString("PostalCode")
            );
            return customerDto;
        }
        return null;
    }
    
    public ArrayList<CustomerDto> getAll() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rst = statement.executeQuery();
        ArrayList <CustomerDto> customerDtos = new ArrayList<>();
        
        while(rst.next()){
                    CustomerDto customerDto = new CustomerDto(
                    rst.getString("CustID"),
                    rst.getString("CustTitle"),
                    rst.getString("CustName"),
                    rst.getString("DOB"),
                    rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"),
                    rst.getString("PostalCode")
            );
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }
}
