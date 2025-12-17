/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edu.self.mvc;
import edu.self.mvc.view.CustomerForm;
import edu.self.mvc.view.ItemForm;

/**
 *
 * @author Anjana Lakshan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ItemForm().setVisible(true);
        new CustomerForm().setVisible(true);
    }
}
