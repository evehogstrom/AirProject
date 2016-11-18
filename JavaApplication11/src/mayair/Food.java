package myair;


public class Food {

	private String foodMenu;
	private FoodtypeEnum foodType;
	private double foodPrice;
        
	public Food(String foodMenu, FoodtypeEnum foodType , double foodPrice){
		this.foodMenu = foodMenu;
		this.foodType = foodType;
	        this.foodPrice = foodPrice;
        }

	public String getFoodMenu() {
		return foodMenu;
	}

	public FoodtypeEnum getFoodType() {
		return foodType;
	}
	        
        public double getfoodPrice() {
		return foodPrice;
	}
        @Override
        public String toString() {
		
            return foodType +  " " + foodMenu + " "  + foodPrice;
		
        }
        
}
