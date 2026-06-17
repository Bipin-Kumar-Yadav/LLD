package StatePattern.Solution;

public class Client {
    public static void main(String[] args) {
        TransportService service = new TransportService(new Walking());
        service.setMode(new Car());
        System.out.println("ETA: "+ service.getEta());
        System.out.print("Direction: "+ service.getDirection());
    }
}
