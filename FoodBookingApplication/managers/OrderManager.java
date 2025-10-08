package FoodBookingApplication.managers;

import java.util.ArrayList;
import java.util.List;

import FoodBookingApplication.models.Order;

public class OrderManager {
    private List<Order> orders = new ArrayList<>();
    private static OrderManager instance = null;

    private OrderManager(){

    }

    public static OrderManager getInstance(){
        if(instance == null){
            instance = new OrderManager();
        }
        return instance;
    } 

    public void addOrder(Order od){
        orders.add(od);
    }

    public void listOrder(){
        System.out.println("\n ------All Orders-------");
        for(Order order : orders){
            System.out.println(order.getType() + " order for " + order.getUser().getName()
                    + " | Total: ₹" + order.getTotal()
                    + " | At: " + order.getScheduled());
        }
    }
}
