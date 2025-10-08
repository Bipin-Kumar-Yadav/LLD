package FoodBookingApplication.strategies;

public class InternetBanking implements  PaymentStrategy {
    private String netBankingId;

    public InternetBanking(String netBankingId){
        this.netBankingId = netBankingId;
    }

    @Override
    public void pay(double amount){
        System.out.println("Paid ₹: "+ amount + " via NetBanking: "+ netBankingId);
    }
}
