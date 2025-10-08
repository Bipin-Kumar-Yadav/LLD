package FoodBookingApplication;

import java.util.List;

import FoodBookingApplication.models.Order;
import FoodBookingApplication.models.Restaurant;
import FoodBookingApplication.models.User;
import FoodBookingApplication.strategies.Upi;

public class Main {
    public static void main(String[] args) {
        // Simulating a happy flow
        // Create TomatoApp Object
        TomatoApp app = new TomatoApp();

        // Simulate a user coming in
        User user = new User("Bipin","Bengaluru");
        System.out.println("User: "+ user.getName() + " is active");

        //User searches for restaurants 
        List<Restaurant> restaurants = app.searchRestaurantsByLocation("Bengaluru");
        if(restaurants.isEmpty()){
            System.out.println("No restaurants found");
            return;
        }

        System.out.println("Found Restaurants:");
        for(Restaurant r: restaurants){
            System.out.println("- "+r.getName());
        }

        //User selects a restaurant
        app.selectRestaurant(user,restaurants.get(0));
        System.out.println("Selected Restaurant: "+ restaurants.get(0).getName());


        //User adds items to cart 
        app.addToCart(user,"P1");
        app.addToCart(user,"P2");

        app.printUserCart(user);

        //user checks out the cart
        Order order = app.checkoutNow(user,"Delivery",new Upi("1234567890"));

        //User pays for the order, If payment is successful, order is placed
        app.payForOrder(user,order);
    }
}
