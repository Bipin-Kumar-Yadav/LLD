package FacadePattern.Solution;

public class Client {
    public static void main(String[] args) {
        ApiGateway apiGateway = new ApiGateway();
        System.out.println(apiGateway.fullOrderDetails("yadavb6","order2","payment1"));
    }
}
