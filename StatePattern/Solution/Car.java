package StatePattern.Solution;

public class Car implements TransportationMode{

    @Override
    public String getDirection() {
       
        return "Direction for Car: ";
    }

    @Override
    public int getEta() {
        System.out.println("ETA for car: ");
        return 10;
    }
    
}
