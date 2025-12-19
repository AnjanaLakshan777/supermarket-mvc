/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.self.mvc.controllers;
import edu.self.mvc.dto.CustomerDto;
import edu.self.mvc.models.CustomerModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Anjana Lakshan
 */
public class CustomerController {
    private CustomerModel customerModel = new CustomerModel();
    
    public String saveCustomer(CustomerDto customerDto)throws ClassNotFoundException, SQLException{
        return customerModel.saveCustomer(customerDto);
    }
    public String updateCustomer(CustomerDto customerDto) throws ClassNotFoundException, SQLException{
        return customerModel.updateCustomer(customerDto);
    } 
    public String deleteCustomer(String customerId) throws ClassNotFoundException, SQLException{
        return customerModel.deleteCustomer(customerId);
    } 
    public CustomerDto getCustomer(String customerId) throws ClassNotFoundException, SQLException{
        return customerModel.getCustomer(customerId);
    }
    public ArrayList<CustomerDto> getAll() throws ClassNotFoundException, SQLException{
        return customerModel.getAll();
    }
}
