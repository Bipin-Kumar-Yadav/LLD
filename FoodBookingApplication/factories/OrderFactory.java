package FoodBookingApplication.factories;

import java.util.List;

import FoodBookingApplication.models.Cart;
import FoodBookingApplication.models.MenuItem;
import FoodBookingApplication.models.Order;
import FoodBookingApplication.models.Restaurant;
import FoodBookingApplication.models.User;
import FoodBookingApplication.strategies.PaymentStrategy;

public interface OrderFactory {
    Order createOrder(User user,Cart cart, Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy,double totalCost, String OrderType);
}
