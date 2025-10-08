package FoodBookingApplication;

import java.util.List;

import FoodBookingApplication.factories.NowOrderFactory;
import FoodBookingApplication.factories.OrderFactory;
import FoodBookingApplication.factories.SchduledOrderFactory;
import FoodBookingApplication.managers.OrderManager;
import FoodBookingApplication.managers.RestaurantsManager;
import FoodBookingApplication.models.Cart;
import FoodBookingApplication.models.MenuItem;
import FoodBookingApplication.models.Order;
import FoodBookingApplication.models.Restaurant;
import FoodBookingApplication.models.User;
import FoodBookingApplication.services.NotificationServices;
import FoodBookingApplication.strategies.PaymentStrategy;

public class TomatoApp {
    public TomatoApp(){
        initializeRestaurants();
    }

    private void initializeRestaurants(){
        Restaurant restaurant1 = new Restaurant("Bikaner", "Delhi");
        restaurant1.addMenuItem(new MenuItem("P1", "Chole Bhature", 120));
        restaurant1.addMenuItem(new MenuItem("P2", "Samosa", 15));

        Restaurant restaurant2 = new Restaurant("Haldiram", "Bengaluru");
        restaurant2.addMenuItem(new MenuItem("P1", "Raj Kachori", 80));
        restaurant2.addMenuItem(new MenuItem("P2", "Pav Bhaji", 100));
        restaurant2.addMenuItem(new MenuItem("P3", "Dhokla", 50));

        Restaurant restaurant3 = new Restaurant("Saravana Bhavan", "Bengaluru");
        restaurant3.addMenuItem(new MenuItem("P1", "Masala Dosa", 90));
        restaurant3.addMenuItem(new MenuItem("P2", "Idli Vada", 60));
        restaurant3.addMenuItem(new MenuItem("P3", "Filter Coffee", 30));


        RestaurantsManager restaurantsManager = RestaurantsManager.getInstance();
        restaurantsManager.addRestaurants(restaurant1);
        restaurantsManager.addRestaurants(restaurant2);
        restaurantsManager.addRestaurants(restaurant3);
    }

    public List<Restaurant> searchRestaurantsByLocation(String loc){
        return RestaurantsManager.getInstance().searchByLocation(loc);
    }

    public void selectRestaurant(User user, Restaurant restaurant){
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }


    public void addToCart(User user, String code){
        Restaurant restaurant = user.getCart().getRestaurant();
        if(restaurant == null){
            System.out.println("Please select a restaurants first");
            return;
        }
        for(MenuItem item : restaurant.getMenu()){
            if(item.getCode().equals(code)){
                user.getCart().addItems(item);
                break;
            }
        }
    }
   
    public Order checkoutNow(User user,String orderType, PaymentStrategy paymentStrategy) {
        return checkout(user,orderType,paymentStrategy, new NowOrderFactory());
    }

    public Order checkoutScheduled(User user,String orderType, PaymentStrategy paymentStrategy, String scheduledTime){
        return checkout(user,orderType,paymentStrategy,new SchduledOrderFactory(scheduledTime));
    }

    public Order checkout(User user,String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory){
        if(user.getCart().isEmpty()){
            return null;
        }
        Cart userCart = user.getCart();
        Restaurant orderedRestaurant = userCart.getRestaurant();
        List<MenuItem> itemsOrdered = userCart.getItems();
        double TotalCost = userCart.getTotalAmount();

        Order order = orderFactory.createOrder(user,userCart, orderedRestaurant, itemsOrdered, paymentStrategy, TotalCost, orderType);
        OrderManager.getInstance().addOrder(order);
        return order;
    }
    
    public void payForOrder(User user, Order order){
        boolean isPaymentSuccess = order.processPayment();

        if(isPaymentSuccess){
            NotificationServices.notify(order);
            user.getCart().clearCart();
        }
    }
    public void printUserCart(User user) {
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getCart().getItems()) {
            System.out.println(item.getCode() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : ₹" + user.getCart().getTotalAmount());
    }
}
