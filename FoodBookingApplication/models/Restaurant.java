package FoodBookingApplication.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int nextRestaurantId = 0;
    private int restaurantId;
    private String name;
    private String location;
    private List<MenuItem> menu = new ArrayList<>();

    public Restaurant(String name, String location){
        this.restaurantId = ++nextRestaurantId;
        this.name = name;
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void addMenuItem(MenuItem item){
        this.menu.add(item);
    }

    public List<MenuItem> getMenu(){
        return menu;
    }

    public int getRestaurantId(){
        return restaurantId;
    }
}
