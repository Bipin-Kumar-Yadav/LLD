package StatePattern.Problem;

public class TransportationService {
    private TransportationMode transportationMode;

    public TransportationService(TransportationMode transportationMode){
        this.transportationMode = transportationMode;
    }

    public void setTransportationMode(TransportationMode transportationMode){
        this.transportationMode = transportationMode;
    }

    public int getETA(){
        switch(transportationMode){
            case CYCLING:
                return 10;

            case WALKING:
                return 20;
            case CAR:
                return 5;

            case TRAIN:
                return 7;
            default:
                throw new IllegalArgumentException("Unidentified Mode");
        }
    }
    public String getDirection(){
        switch (transportationMode) {
            case CYCLING:
                
               return "Direction for Cycling";
            case WALKING:
                return "Direction for Walking";
            case TRAIN:
                return "Direction for Train";
            case CAR:
                return "Direction for Car";
            default:
                throw new IllegalArgumentException("Unidentified Mode");
        }
    }
}
