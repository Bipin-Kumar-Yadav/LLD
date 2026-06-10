package FacadePattern.Problem;

public class Client {
    public static void main(String[] args) {
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        // task
        System.out.println(userService.getUserDetails("yadavb6"));
        System.out.println(orderService.getOrderDetails("order1"));
        System.out.println(paymentService.getPaymentDetails("payment1"));
    }
}
