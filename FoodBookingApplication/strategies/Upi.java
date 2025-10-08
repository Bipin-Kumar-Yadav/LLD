package FoodBookingApplication.strategies;

public class Upi implements PaymentStrategy {
    private String mob;

    public Upi(String mob){
        this.mob = mob;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paid ₹: "+ amount + " via UPI : "+mob);
    }
}
