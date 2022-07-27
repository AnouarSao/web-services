/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jakartademo.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

/**
 *
 * @author Anouar-Sao
 */
public class Directory {
    
    private ArrayList<Customer> customers = new ArrayList<>();
    private long index = 0;
    
    public ArrayList<Customer> getAll(){
        return customers;
    }
    
    public void add(Customer customer){
        customer.setId(index);
        index++;
        customers.add(customer);
    }
    
    public Optional<Customer> findById(Long id){
        Optional<Customer> o = Optional.empty();
        
        for(Customer c : customers){
            if(c.getId().equals(id)){
                o = Optional.of(c);
                //return o;
                break;
            }
        }
        return o;
    }
    
    public void delete(long id){
        for(Customer c : customers){
            if(c.getId().equals(id)){
                customers.remove(c);
                break;
            }
        }
        
//        Iterator<Customer> it = customers.iterator();
//        while(it.hasNext()){
//            Customer c = it.next();
//            if(c.getId().equals(id)){
//                customers.remove(c);
//                break;
//            }
//        }
    }
    
//    public void update(Customer customer){
//        for(Customer c : customers){
//            if(c.getId().equals(customer.getId())){
//                customers.remove(c);
//                customers.add(customer);
//                break;
//            }
//        }
//    }
    
    public void update(Customer customer){
        System.out.println("update()");
        Iterator<Customer> it = customers.iterator();
        while(it.hasNext()){
            Customer c = it.next();
            if(c.getId().equals(customer.getId())){
                customers.remove(c);
                customers.add(customer);
                break;
            }
        }
    }
}
