package myair;


public class Ticket {
    
    private static int ticketIdCounter;
    private double ticketPrice;
    
    private int ticketId;
    private Customer customer;
    private int seatNo;
    private String flightNo;
    private String departure;
    private String departureDate;
    private String destination;
    private String destinationDate;
    private String foodOrdering;
    private double foodPrice;
   
    private static double income;
    
    public Ticket(Customer customer, int seatNo, String flightNo, String departure, 
            String departureDate, String destination, String destinationDate, 
            String foodOrdering, double foodPrice){
      
       ticketIdCounter++;
       this.ticketId = ticketIdCounter;
       this.customer = customer;

       this.seatNo = seatNo;
       this.flightNo = flightNo;
       this.departure = departure;
       this.departureDate = departureDate;
       this.destination = destination;
       this.destinationDate = destinationDate;
       this.foodOrdering = foodOrdering;
       this.foodPrice = foodPrice;
       
       if (seatNo < 6) {
           ticketPrice = 20000;
       }
       else {
           ticketPrice = 5000;
       }
       
       income = income + (this.foodPrice + this.ticketPrice);
    }
    
    public double getTotalPriceForCustomer() {
        return (this.foodPrice + this.ticketPrice);
    }
    
    public double getProfit() {
        return (income * 0.3);
    }

    @Override
    public String toString() {
        return ("Ticket No : " + ticketId + "\n" +
                "Name : " + customer.getFirstName() + " " + customer.getSureName() +  "\n" +
                "Seat No : " + seatNo + "\n" +
                "Flight No : " + flightNo + "\n" +
                "Departure : " + departure + " " + departureDate + "\n" +
                "Destination : " + destination + " " + destinationDate + "\n" +
                "Food ordering and price : " + foodOrdering + " " + foodPrice +  "\n" +
                "Ticket price : " + ticketPrice + "\n" +
                "Total price : " + (foodPrice + ticketPrice));
    }
}