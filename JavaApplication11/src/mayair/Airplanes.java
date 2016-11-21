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
public class Airplanes {
    private ArrayList<Airplane> airplanes;    
                
    public Airplanes(){
        airplanes = new ArrayList<>();
    }
    
    public void add(Airplane airplane){
        airplanes.add(airplane);     
    }
     
     public void remove(Airplane airplane){
        this.airplanes.remove(airplane);     
    }
    
     public void removeAll(){
        this.airplanes.removeAll(airplanes);     
    }   

    public Airplane findAirplanById(String sAirplaneById){ 
		
		for (Airplane nextAirplane: airplanes)
		{						
                    if(nextAirplane.getFlightId().equals(sAirplaneById)){
                            return nextAirplane;
			}	    
		}
			
                return null;
}
     
    public void listAirplane(){
              
        for (Airplane nextAirplane : airplanes) {
                
            System.out.println("");             
            System.out.println(nextAirplane.getPlaneName());
            System.out.println(nextAirplane.getFlightId() + " " + nextAirplane.getDepatureDestination() + " " + nextAirplane.getDepatureDateTime() + " - " + nextAirplane.getArrivaleDestination() + " " + nextAirplane.getArrivaleDateTime() + " " + nextAirplane.getAirPlaneStatus()  );                       
            System.out.println("");                                   
            
        }
            
        System.out.println("");                 
            
        }       
        
public void listAirplaneAndSeats(){
              
        for (Airplane nextAirplane : airplanes) {
                
            System.out.println("");             
            System.out.println(nextAirplane.getPlaneName());
            System.out.println(nextAirplane.getFlightId() + " " + nextAirplane.getDepatureDestination() + " " + nextAirplane.getDepatureDateTime() + " - " + nextAirplane.getArrivaleDestination() + " " + nextAirplane.getArrivaleDateTime() );                       
            System.out.println("");                                   
            
            Seats seats;
            
            seats = nextAirplane.getSeats();
            seats.listSeats("");         
                        
            System.out.println("");                 
            
        }
            
        System.out.println("");                 
            
        }       
  
    } 



