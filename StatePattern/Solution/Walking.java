package StatePattern.Solution;
 
public class Walking implements TransportationMode{

    @Override
    public String getDirection() {
        return "Direction for Walking:";
    }

    @Override
    public int getEta() {
        System.out.println("ETA for walking: ");
        return 20;
    }
    
}
