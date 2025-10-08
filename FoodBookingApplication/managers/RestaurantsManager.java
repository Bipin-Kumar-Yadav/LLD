package FoodBookingApplication.managers;

import java.util.ArrayList;
import java.util.List;

import FoodBookingApplication.models.Restaurant;

public class RestaurantsManager {
    public List<Restaurant> restaurants = new ArrayList<>();
    private static  RestaurantsManager instance = null;

    private RestaurantsManager(){

    }

    public static RestaurantsManager getInstance(){
        if(instance == null){
            instance = new RestaurantsManager();
        }
        return instance;
    }

    public void addRestaurants(Restaurant r){
        restaurants.add(r);
    }

    public List<Restaurant> searchByLocation(String loc){
        List<Restaurant> result = new ArrayList<>();
        loc = loc.toLowerCase();
        for(Restaurant r : restaurants){
            String rl = r.getLocation().toLowerCase();
            if(rl.equals(loc)){
                result.add(r);
            }
        }
        return result;
    }
}
