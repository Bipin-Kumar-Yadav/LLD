package StatePattern.Problem;

public class Client {
    public static void main(String[] args) {
        TransportationService transportationService = new TransportationService(TransportationMode.WALKING);
        System.out.println("ETA: " +transportationService.getETA());
        System.out.println(transportationService.getDirection());
    }
}
