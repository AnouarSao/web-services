/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.poe.jakartademo;

import com.mycompany.jakartademo.business.Customer;
import com.mycompany.jakartademo.business.Directory;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Anouar-Sao
 */
public class DirectoryTest {
   
    @Test
    public void testAddAndFindById(){
        Directory directory = new Directory();
        directory.add(new Customer("Alain", "Delon"));
        Optional<Customer> op = directory.findById(0L);
        if(op.isPresent()){
            Customer customer = op.get();
            System.out.println(customer);
            Assert.assertEquals("Alain", customer.getFirstName());
        }
    }

    
    @Test
    public void testDeleteAndGetAll(){
        Directory directory = new Directory();
        directory.add(new Customer("Alain", "Delon"));
        directory.add(new Customer("Michel", "Dupont"));
        directory.add(new Customer("Marie", "Durand"));
        
        int size = directory.getAll().size();
        System.out.println(size); 
        
        directory.delete(1L);
        
        Assert.assertEquals(size-1, directory.getAll().size());
        System.out.println(directory.getAll().size());  
        Assert.assertTrue(directory.findById(1L).isEmpty());
        
        Assert.assertTrue(directory.findById(2L).isPresent());
    }
    
    @Test
    public void testUpdate(){
        Directory directory = new Directory();
        directory.add(new Customer("Alain", "Delon"));
        directory.add(new Customer("Michel", "Dupont"));
        directory.add(new Customer("Marie", "Durand"));
        
        Optional<Customer> op = directory.findById(1L);
        if(op.isPresent()){
            Customer customer = op.get();
            Assert.assertEquals("Michel", customer.getFirstName());
            
            customer.setFirstName("Didier");
            directory.update(customer);
            
            Assert.assertEquals(3, directory.getAll().size());
            
            Optional<Customer> op2 = directory.findById(1L);
            if(op2.isPresent()){
                Customer c2 = op2.get();
                Assert.assertEquals("Didier", c2.getFirstName());
            }
        }
    }
}
