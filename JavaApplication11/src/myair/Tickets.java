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
public class Tickets {
     private ArrayList<Ticket> tickets;   
     
    public Tickets(){
        tickets = new ArrayList<>();
    }
    
    public void add(Ticket ticket){
        tickets.add(ticket);     
    }
    
    public void listTikets(){        
        
        for (Ticket ticket : tickets) {
            System.out.println();
            System.out.println(ticket.toString());                
            System.out.println();
        }
                         
       }
     public void remove(Ticket ticket){
        this.tickets.remove(ticket);     
    }
    
     public void removeAll(){
        this.tickets.removeAll(tickets);     
    }
    
}
