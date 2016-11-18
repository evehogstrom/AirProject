package myair;

import mayair.AirPlanStatus;


public class Airplane {

	//ArrayList<Seat> seats = new ArrayList<Seat>();
	
    private String planeName;
        private Seats seats;
        private String flightId ;
        private String depatureDestination;
        private String arrivaleDestination;
        private String depatureTime;
        private String arrivaleTime;
        private AirPlanStatus eArplanStatus;
        
// public Airplane(ArrayList<Seat> seats, String planeName) {
    
	public Airplane(Seats seats, String planeName, String  flightId, String depatureDestination,String depatureTime, String arrivaleDestination,String arrivaleTime){
		this.seats = seats;
		this.planeName = planeName;
                this.flightId = flightId;
                this.depatureDestination = depatureDestination;
                this.arrivaleDestination = arrivaleDestination;
                this.depatureTime=depatureTime;
                this.arrivaleTime=arrivaleTime;
                eArplanStatus = AirPlanStatus.ONAIRPORT;
                
	}

	public String getPlaneName() {
		return planeName;
	}

        public String getDepatureDestination() {
		return depatureDestination;
	}
        
        public String getArrivaleDestination() {
		return arrivaleDestination;
	}

         public String getFlightId() {
		return flightId;
	}
        public String getDepatureDateTime() {
		return depatureTime;
	}
        public String getArrivaleDateTime() {
		return arrivaleTime;
	}    
        
        public Seats getSeats() {
		return seats;
	}    
        
        public AirPlanStatus getAirPlaneStatus() {
            return eArplanStatus;
	}  
        
        public void setAirPlaneStatus(AirPlanStatuse eArplanStatus ) {
            this.eArplanStatus = eArplanStatus;
	}  
               
        @Override
	public String toString() {
		return planeName + "\n" + seats;
	}

}