package FacadePattern.Problem;

public class OrderService {
    public String getOrderDetails(String orderId){
        return String.format("Order details for orderId %s",orderId);
    }
}
