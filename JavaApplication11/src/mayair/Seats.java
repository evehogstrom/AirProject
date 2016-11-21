/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myair;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author User
 */
public class Seats {
  private ArrayList<Seat> seats;    
        
    public Seats(){
        seats = new ArrayList<>();
    }
    
    public void add(Seat seat){
        seats.add(seat);     
    }
    
    public Seat findSeat(int nSeat){ 
		
		for (Seat nextSeat: seats)
		{						
			if (nSeat == nextSeat.getSeatNumber() && nextSeat.isReserved()== false){
				return nextSeat;
			}	
		}
			
		return null;
	}
       
    public void listSeats(String sSeatType){
        String sSeatlist;
        sSeatlist = " ";
        
        for (Seat seat : seats) {
            if(seat.getSeatClass() == sSeatType )
            {                              
                if (seat.isReserved()){
                    System.out.println(seat.getSeatNumber() + " [Reserved] " + seat.getSeatClass());                     
                }
                else{
                    System.out.println(seat.getSeatNumber() + " [ ] " + seat.getSeatClass() + " " + seat.getSeatPrice());
                }
             }else{
                if (seat.isReserved()){
                    System.out.println(seat.getSeatNumber() + " [Reserved] " + seat.getSeatClass());                     
                }
                else{
                    System.out.println(seat.getSeatNumber() + " [ ] " + seat.getSeatClass() + " " + seat.getSeatPrice());
                }
                
            }
        }
                
       }
     
     public void remove(Seat seat){
        this.seats.remove(seat);     
    }
    
     public void removeAll(){
        this.seats.removeAll(seats);     
    } 
}
