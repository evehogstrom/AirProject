/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myair;
import java.lang.Runnable;
import myair.AirPlanStatus;
import myair.Airplane;
import myair.Airplanes;
/**
 *
 * @author User
 */
public class AirPlanSendOff implements Runnable {
   private Airplane  objArplane;
   private Airplanes  objArplanes;
   private int nTime;
   
    public void run( ) {       
    
     sendOffAirPlane(objArplane,objArplanes);   
        
    }
    
    public void setObjects(Airplane objArplane, Airplanes objArplanes){
        this.objArplane = objArplane;
        this.objArplanes = objArplanes;  
        
    }
    
    public void sendOffAirPlane(Airplane objArplane,Airplanes objArplanes ){
    {   
        this.objArplane = objArplane;
        this.objArplanes = objArplanes;        
        nTime = 10000;
        
    try {                
                    objArplane.setAirPlaneStatus(AirPlanStatus.TAKEOFF);
                    objArplanes.listAirplane();
                    Thread.sleep(nTime);
                    objArplane.setAirPlaneStatus(AirPlanStatus.FLIGHT);
                    objArplanes.listAirplane();
                    Thread.sleep(nTime);
                    objArplane.setAirPlaneStatus(AirPlanStatus.LANDING);
                    objArplanes.listAirplane();
                    Thread.sleep(nTime);
                    objArplane.setAirPlaneStatus(AirPlanStatus.REFUELING);
                    objArplanes.listAirplane();
                    Thread.sleep(nTime);
                    objArplane.setAirPlaneStatus(AirPlanStatus.ONAIRPORT);                   
                    
                    Seats seats;
                    seats = objArplane.getSeats();                    
                    seats.clearSeats();
                    
                    String sArrivaleDestination = objArplane.getArrivaleDestination();
                    String sDepatureDestination = objArplane.getDepatureDestination();
                            
                    objArplane.setDepatureDestination(sArrivaleDestination);
                    objArplane.setArrivaleDestination(sDepatureDestination);
                    
                         
                    objArplanes.listAirplane();
                    Thread.sleep(nTime);
                    
            }   catch (Exception e) {
                
            }          
}
    
   }
}