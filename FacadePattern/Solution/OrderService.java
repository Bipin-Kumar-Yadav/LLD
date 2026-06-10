package FacadePattern.Solution;

public class OrderService {
    public String getOrderDetails(String orderId){
        return String.format("Order details for orderId %s",orderId);
    }
}
