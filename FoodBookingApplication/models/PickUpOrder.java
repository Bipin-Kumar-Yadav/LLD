package FoodBookingApplication.models;

public class PickUpOrder extends Order{

    private String resAddress;

    public PickUpOrder(){
        resAddress = "";
    }


    @Override
    public String getType(){
        return "Pickup";
    }

    public void setResAddress(String add){
        this.resAddress = add;
    }

    public String getResAddress(){
        return resAddress;
    }
    
}
