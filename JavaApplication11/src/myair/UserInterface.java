/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myair;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class UserInterface {

    private static int nInteger;
    private static int customerId;

    private Tickets objTickets = new Tickets();
    private Ticket objTicket;

    private Seats objSeats = new Seats();
    private Seat objSeat;

    private Foods objFoods = new Foods();
    private Food objFood;

    private Airplanes objArplanes = new Airplanes();
    private Airplane objArplane;
  
    private String sFoodType = "";
    private double sFoodPrice = 0;

    private boolean nRun;
   

    public UserInterface() {

        nRun = false;

        initFood();
        initSeats();

        while (nRun != true) {

            Scanner sc = new Scanner(System.in,"Cp1252");
            
            
            System.out.println("|------------------------------|");
            System.out.println("|1:Booking                     |");
            System.out.println("|2:List bookings               |");
            System.out.println("|3:List Destinations           |");
            System.out.println("|4:List Destinations/airplanes |");
            System.out.println("|------------------------------|");
            System.out.println("|5:Total income for company    |");            
            System.out.println("|------------------------------|");
            System.out.println("|6:Exit                        |");            
            System.out.println("|------------------------------|");
            System.out.println("|7: Send off airplane          |");            
            System.out.println("|------------------------------|");
            System.out.println("Enter your command: ");
            
            int nInteger = inputInteger();
            
            //int nInteger = sc.nextInt();
            
            boolean bRun = false;
            int nFood = 0;
            int nSeat = 0;

            switch (nInteger) {
                case 1: {

                    System.out.println("1: Start booking ");
                    System.out.println("");

                    bRun = false;
                    while (bRun != true) {
                        
                        objArplanes.listAirplane();
                        System.out.println();
                        System.out.println("Enter your destination:");
                        String sDestination = sc.next();
                        objArplane = objArplanes.findAirplanById(sDestination);

                        if (objArplane == null || objArplane.getAirPlaneStatus() != AirPlanStatus.ONAIRPORT  ) {
                            bRun = false;
                        } else {
                            bRun = true;
                        }
                    }

                    System.out.println("Selected destination is " + objArplane.getFlightId() + " " + objArplane.getDepatureDestination() + " " + objArplane.getDepatureDateTime() + " - " + objArplane.getArrivaleDestination() + " " + objArplane.getArrivaleDateTime());
                    System.out.println();

                    customerId++;

                    System.out.println("Enter your Firstname:");
                    String sFirstName = sc.next();

                    System.out.println("Enter your Surname:");
                    String sSureName = sc.next();

                    Customer objCustomer = new Customer(sFirstName, sSureName);

                    objSeats = objArplane.getSeats();

                    bRun = false;

                    while (bRun != true) {

                        System.out.println();
                        objSeats.listSeats("");
                        System.out.println();

                        System.out.println("Enter seat number? ");

                        nSeat = inputInteger();
                       
                        //nSeat = sc.nextInt();
                        objSeat = objSeats.findSeat(nSeat);
                                              
                        if (objSeat == null) {
                            bRun = false;
                            System.out.println("Seat number not found!");

                        } else {
                            bRun = true;
                        }
                    }

                    objSeat.setReserved(true);
                    objSeats.listSeats("");

                    bRun = false;

                    while (bRun != true) {

                        System.out.println("");
                        System.out.println("Do you want food?");
                        System.out.println("-----------------");
                        System.out.println("1 Yes");
                        System.out.println("2 No");
                        System.out.println("");

                        nFood = 0;
                        nFood = inputInteger();
                                                
                        // nFood = sc.nextInt();
                                                
                        if (nFood == 1 || nFood == 2) {
                            bRun = true;
                        } else {
                            bRun = false;
                            System.out.println("Wrong selection!");
                        }

                    }

                    sFoodType = "";
                    sFoodPrice = 0;

                    if (nFood == 1) {
                        objCustomer.setFoodStatus(true);
                        if (nSeat <= 5) {
                            
                            bRun = false;

                    while (bRun != true) {
                        
                    
                            objFoods.listFood(FoodtypeEnum.FirstClass);
                            System.out.println("-----------------");
                            System.out.println("Select food from list!");
                            sFoodType = sc.next();

                            objFood = objFoods.findFood(sFoodType, FoodtypeEnum.FirstClass);
                            
                            if (objFood == null) {
                            bRun = false;
                            System.out.println("Selected food not found!");

                            } else {
                                bRun = true;
                            }
                    }        
                                        
                            
                            sFoodType = objFood.getFoodMenu();
                            sFoodPrice = objFood.getfoodPrice();
                            
                        } else {
                           
                            bRun = false;

                    while (bRun != true) {
                            
                            
                            objFoods.listFood(FoodtypeEnum.EconomyClass);
                            System.out.println("-----------------");
                            System.out.println("Select food from list!");
                            sFoodType = sc.next();
                            
                            objFood = objFoods.findFood(sFoodType, FoodtypeEnum.EconomyClass);
                            
                            if (objFood == null) {
                            bRun = false;
                            System.out.println("Selected food not found!");

                            } else {
                                bRun = true;
                            }                            
                    }        
                            
                            
                            sFoodType = objFood.getFoodMenu();
                            sFoodPrice = objFood.getfoodPrice();
                        }

                    } else {
                        objCustomer.setFoodStatus(false);

                        sFoodType = "No food";
                        sFoodPrice = 0;
                    }

                    objTicket = new Ticket(objCustomer, nSeat, objArplane.getFlightId(), objArplane.getDepatureDestination(), objArplane.getDepatureDateTime(), objArplane.getArrivaleDestination(), objArplane.getArrivaleDateTime(), sFoodType, sFoodPrice);
                    objTickets.add(objTicket);

                    System.out.println();
                    System.out.println(objTicket.toString());
                    System.out.println();
                }

                break;

                case 2: {

                    System.out.println("2: List Bookings");
                    System.out.println();
                    objTickets.listTikets();
                    System.out.println();

                    break;
                }
                case 3: {
                    System.out.println("3: List Destinations");
                    System.out.println();
                    objArplanes.listAirplane();
                    System.out.println();

                    break;
                }
                case 4: {

                    System.out.println("4: List Destinations");
                    System.out.println();
                    objArplanes.listAirplaneAndSeats();
                    System.out.println();

                    break;
                }
                case 5: {

                    try {
                        System.out.println("5: Total income for company ");
                        System.out.println();
                        System.out.println("Total income for company " + objTicket.getProfit());
                        System.out.println();
                    } catch (NullPointerException e) {
                        System.out.println("Total income for company = 0.00 ");
                        System.out.println();
                    }
                }

                break;
                
                case 6: {
                    System.out.println("6: Exit ");
                    nRun = true;
                    sc.close();
                }
                break;
                
                case 7:  {
               
                    System.out.println("7: Sending off Airplan  ");
                                      
                    while (bRun != true) {
                        objArplanes.listAirplane();
                        System.out.println();
                        System.out.println("Enter airplan to send off:");
                        String sDestination = sc.next();
                        objArplane = objArplanes.findAirplanById(sDestination);
                        if (objArplane == null) {
                            bRun = false;
                        } else {
                            bRun = true;
                        }
                    }                   
                     
                    AirPlanSendOff task = new AirPlanSendOff();
                    task.setObjects(objArplane,objArplanes);                   
                                               
                    Thread airplanThrads = new Thread(task);
                    airplanThrads.start();
                    
                    
                break;
                
                }
                
                default:

                    break;
            }
        }
    }
      
    public void initFood()
    {
        objFood  = new Food("Steak", FoodtypeEnum.EconomyClass, 150);
        objFoods.add (objFood);
        objFood  = new Food("Soup", FoodtypeEnum.EconomyClass, 100);
        objFoods.add (objFood);        
        objFood  = new Food("Sandwitch", FoodtypeEnum.EconomyClass, 50);
        objFoods.add (objFood);
        objFood  = new Food("Oyster", FoodtypeEnum.FirstClass, 500);      
        objFoods.add (objFood);
        objFood  = new Food("Sirloin ", FoodtypeEnum.FirstClass, 400);
        objFoods.add (objFood);
        objFood  = new Food("Lobster" , FoodtypeEnum.FirstClass, 300);
        objFoods.add (objFood);       
}
   
       public void initSeats(){
                        
        objSeat = new Seat(1, "First Class", 20000);
        objSeats.add (objSeat);
        objSeat = new Seat(2, "First Class", 20000);
        objSeats.add (objSeat);
        objSeat = new Seat(3, "First Class", 20000);
        objSeats.add (objSeat);
        objSeat = new Seat(4, "First Class", 20000);
        objSeats.add (objSeat);
        objSeat = new Seat(5, "First Class", 20000);
        objSeats.add (objSeat);

        objSeat = new Seat(6, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(7, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(8, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(9, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(10, "Economic Class", 5000);
        objSeats.add (objSeat);
                      
        objArplane = new Airplane(objSeats, "Lexicon Air One","TFS123","Arlanda","2016-12-01 07:00","Teneriffa","2016-12-01 14:00");
        objArplanes.add(objArplane);  
        
        Seats objSeats = new Seats();
        
        objSeat = new Seat(1, "First Class", 20000);
        objSeats.add (objSeat);
        objSeat = new Seat(2, "First Class", 20000);
        objSeats.add (objSeat);
        objSeat = new Seat(3, "First Class", 20000);
        objSeats.add (objSeat);
        objSeat = new Seat(4, "First Class", 20000);
        objSeats.add (objSeat);
        objSeat = new Seat(5, "First Class", 20000);
        objSeats.add (objSeat);

        objSeat = new Seat(6, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(7, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(8, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(9, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(10, "Economic Class", 5000);
        objSeats.add (objSeat);
        
        objSeat = new Seat(11, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(12, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(13, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(14, "Economic Class", 5000);
        objSeats.add (objSeat);
        objSeat = new Seat(15, "Economic Class", 5000);
        objSeats.add (objSeat);
        
        objArplane = new Airplane(objSeats, "Gulf Stream One","ARN321","Malaga","2016-12-24 07:00","Arlanda","2016-12-24 14:00");
        objArplanes.add(objArplane);   
              
       Seats objSeats2 = new Seats();
       
       objSeat = new Seat(1, "First Class", 20000);
       objSeats2.add (objSeat);
       objSeat = new Seat(2, "First Class", 20000);
       objSeats2.add (objSeat);
       objSeat = new Seat(3, "First Class", 20000);
       objSeats2.add (objSeat);
       objSeat = new Seat(4, "First Class", 20000);
       objSeats2.add (objSeat);
       objSeat = new Seat(5, "First Class", 20000);
       objSeats2.add (objSeat);
             
       objArplane = new Airplane(objSeats2, "Trump One","USA111","Arlanda","2016-12-11 09:00","New York","2016-12-11 18:00");
       objArplanes.add(objArplane);       
              
       }
       
       
   public void intAirPlanes(){
        
       objArplane = new Airplane(objSeats, "Lexicon Air One","TFS123","Arlanda","2016-12-01 07:00","Teneriffa","2016-12-01 14:00");
       objArplanes.add(objArplane);  
        
       objArplane = new Airplane(objSeats, "Gulf Stream One","ARN321","Malaga","2016-12-24 07:00","Arlanda","2016-12-24 14:00");
       objArplanes.add(objArplane);
              
       objArplane = new Airplane(objSeats, "Trump One","USA111","Arlanda","2016-12-11 09:00","New York","2016-12-11 18:00");
       objArplanes.add(objArplane);         
       
   }
   
   public int inputInteger(){
    
    Scanner sc = new Scanner(System.in,"Cp1252");
    
    int nChoice;    
    nChoice=0;
    
    String input = "";
    boolean notAnInteger = true;
    
    while(notAnInteger){
         input = sc.next();
         try{
             nChoice = Integer.parseInt(input);
             notAnInteger = false;
         }catch(Exception e){
             System.out.println("Not an integer");
         }         
   }
    return  nChoice;
   }      
}

    
   
   

   



