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
public class Foods {
        private ArrayList<Food> foods;    
        
    public Foods(){
        foods = new ArrayList<>();
    }
    
    public void add(Food food){
        foods.add(food);     
    }
     public Food findFood(String sfoodMeny, FoodtypeEnum sfoodType){ 
		
		for (Food nextFood: foods)
		{						
			if(sfoodMeny.equals(nextFood.getFoodMenu()) && sfoodType == nextFood.getFoodType() ){
                            return nextFood;
			}	
		}
			
                return null;
}
     
    public void listFood(FoodtypeEnum foodType){
        String sFoodMeny;
        sFoodMeny = "";
        
        for (Food food : foods) {
            if(food.getFoodType() == foodType)
            {            
              sFoodMeny += food.getFoodMenu() + " " + food.getfoodPrice() + "\n" ;              
            }
        }
        
        System.out.println(foodType); 
        System.out.println("-------------"); 
        System.out.println(sFoodMeny);    
        
       }
     public void remove(Food food){
        this.foods.remove(food);     
    }
    
     public void removeAll(){
        this.foods.removeAll(foods);     
    }
     
     
     
     
}
