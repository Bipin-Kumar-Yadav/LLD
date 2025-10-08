package FoodBookingApplication.factories;

import java.util.List;

import FoodBookingApplication.models.Cart;
import FoodBookingApplication.models.DeliveryOrder;
import FoodBookingApplication.models.MenuItem;
import FoodBookingApplication.models.Order;
import FoodBookingApplication.models.PickUpOrder;
import FoodBookingApplication.models.Restaurant;
import FoodBookingApplication.models.User;
import FoodBookingApplication.strategies.PaymentStrategy;
import FoodBookingApplication.utils.TimeUtils;

public class NowOrderFactory implements OrderFactory{
    
    @Override 
    public Order createOrder(User user,Cart cart,Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy, double totalCost, String orderType){
        Order order = null;

        if(orderType.equalsIgnoreCase("Delivery")){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        }
        else{
            PickUpOrder pickUpOrder = new PickUpOrder();
            pickUpOrder.setResAddress(restaurant.getLocation());
            order = pickUpOrder;
        }
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);

        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(totalCost);
        return order;

    }
}
