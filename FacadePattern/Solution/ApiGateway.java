package FacadePattern.Solution;

public class ApiGateway {
    UserService userService;
    OrderService orderService;
    PaymentService paymentService;

    public ApiGateway(){
        this.userService = new UserService();
        this.orderService = new OrderService();
        this.paymentService = new PaymentService();
    }

    // Task
    public String fullOrderDetails(String userId, String orderId,String paymentId){
        String userDetails = userService.getUserDetails(userId);
        String orderDetails = orderService.getOrderDetails(orderId);
        String paymentDetails = paymentService.getPaymentDetails(paymentId);
        return userDetails + "\n" + orderDetails + "\n" + paymentDetails;
    }
}
