package FacadePattern.Problem;

public class PaymentService {
    public String getPaymentDetails(String paymentId){
        return String.format("Payment detail for paymentId %s", paymentId);
    }
}
