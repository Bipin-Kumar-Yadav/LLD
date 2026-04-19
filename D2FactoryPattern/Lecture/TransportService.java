package D2FactoryPattern.Lecture;

public class TransportService {
    public static void main(String[] args) {
        Transport vehicle = TransportFactory.createTransport("BIKE");
        vehicle.deliver();
    }
}