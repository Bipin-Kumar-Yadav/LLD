package StatePattern.Solution;

public class TransportService {
    private TransportationMode mode;

    public TransportService(TransportationMode mode){
        this.mode = mode;
    }

    public void setMode(TransportationMode mode){
        this.mode = mode;
    }

    public int getEta(){
        return mode.getEta();
    }
    
    public String getDirection(){
        return mode.getDirection();
    }
}
