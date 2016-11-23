/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myair;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Customers {
    private ArrayList<Customer> customers;  
        
    public Customers(){
        customers = new ArrayList<>();
    }
    
    public void add(Customer customer){
        customers.add(customer);     
    }
    public Customer findCustomerById(int customerId ){ 
		
		for (Customer customer: customers)
		{						
			if(customer.getCustomerId() == customerId ){
                            return customer;
			}	
		}
			
               return null;
    }
    
    public void ListCustomers(){        
        
        for (Customer customer : customers) {
            System.out.println();
            System.out.println(customer.toString());                
            System.out.println();
        }
                         
       }
     public void remove(Customer customer){
        this.customers.remove(customer);     
    }
    
     public void removeAll(){
        this.customers.removeAll(customers);     
    } 
}
