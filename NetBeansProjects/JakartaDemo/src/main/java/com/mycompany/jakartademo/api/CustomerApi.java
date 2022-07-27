/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jakartademo.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mycompany.jakartademo.business.Customer;
import com.mycompany.jakartademo.business.Directory;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 *
 * @author Anouar-Sao
 */

@Path("customers")
public class CustomerApi {
   
    
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Customer> getCustomers(@Context HttpServletRequest request){
       
        Directory directory = (Directory)request.getSession().getAttribute("directory");
        if(directory == null){
            directory = new Directory();
            request.getSession().setAttribute("directory", directory);
        }
        return directory.getAll();
        
        
//	System.out.println("getCustomers()");
//	ArrayList<Customer> customers = new ArrayList<>();
//	customers.add(new Customer("Alain", "Dupont"));
//	customers.add(new Customer("Marie", "Dupont"));	
//	return customers;        
    }
    
    @POST()
    @Consumes({ MediaType.APPLICATION_JSON })
    public void postCustomer(Customer customer, @Context HttpServletRequest request){

        Directory directory = (Directory)request.getSession().getAttribute("directory");
        if(directory == null){
            directory = new Directory();
        }
        directory.add(customer);
        request.getSession().setAttribute("directory", directory);
    }
    
    @Path("/{id}")
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getById(@PathParam("id") Long customerId, @Context HttpServletRequest request){
        Directory directory = (Directory)request.getSession().getAttribute("directory");
        if(directory == null){
            directory = new Directory();
        }
        Optional<Customer> customerOptional = directory.findById(customerId);
        
        if(customerOptional.isPresent()){
            return Response.ok( customerOptional.get()).build();        
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("Customer Not Found").build();
        }
        
        
    }
    
    @Path("/{id}")
    @DELETE()
    public void delete(@PathParam("id")Long id, @Context HttpServletRequest request){
        Directory directory = (Directory)request.getSession().getAttribute("directory");
        if(directory == null){
            directory = new Directory();
        }
       directory.delete(id);
        
    }
    
    @Path("/{id}")
    @PUT()
    public void update(Customer customerToUpdate, @Context HttpServletRequest request){
        Directory directory = (Directory)request.getSession().getAttribute("directory");
        if(directory == null){
            directory = new Directory();
        }
        directory.update(customerToUpdate);
    }
}
