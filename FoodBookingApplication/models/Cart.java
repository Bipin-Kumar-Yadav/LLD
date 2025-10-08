package FoodBookingApplication.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private List<MenuItem> items = new ArrayList<>();

    public Cart(){
        restaurant = null;
    }

    public void addItems(MenuItem item){
        if(restaurant == null){
            System.err.println("Cart: Select a restaurant first");
            return;
        }
        items.add(item);
    }

    public double getTotalAmount(){
        double total = 0;
        for(MenuItem i : items){
            total += i.getPrice();
        }
        return total;
    }

    public boolean isEmpty(){
        return restaurant == null || items.isEmpty();
    }

    public void clearCart(){
        items.clear();
        restaurant= null;
    }

    public void setRestaurant(Restaurant res){
        restaurant = res;
    }

    public Restaurant getRestaurant(){
        return restaurant;
    }

    public List<MenuItem> getItems(){
        return items;
    }
}
