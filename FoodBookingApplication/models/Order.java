package FoodBookingApplication.models;

import java.util.List;

import FoodBookingApplication.strategies.PaymentStrategy;

public abstract class Order {
    private static int nextOrderId = 0;
    private int orderId;
    private User user;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private PaymentStrategy paymentStrategy;
    private double total;
    private String scheduled;

    public Order(){
        this.user = null;
        this.restaurant = null;
        this.paymentStrategy = null;
        this.total = 0.0;
        this.scheduled = "";
        this.orderId = ++nextOrderId;
    }

    public boolean processPayment(){
        if(paymentStrategy == null){
            System.err.println("Order: Payment Strategy not set");
            return false;
        }
        else{
            paymentStrategy.pay(total);
            return true;
        }
    }

    public abstract String getType();

    public int getOrderId(){
        return orderId;
    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }
    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }
    public Restaurant getRestaurant(){
        return restaurant;
    }
    public void setItems(List<MenuItem> items){
        this.items = items;
        total = 0;
        for(MenuItem i : items){
            total += i.getPrice();
        }
    }

    public List<MenuItem> getItems(){
        return items;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStrategy getPaymentStrategy(){
        return paymentStrategy;
    }

    public void setScheduled(String scheduled){
        this.scheduled = scheduled;
    }   

    public String getScheduled(){
        return scheduled;
    }

    public double getTotal(){
        return total;
    }

    public void setTotal(double total){
        this.total = total;
    }
}
