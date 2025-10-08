package FoodBookingApplication.models;

public class DeliveryOrder extends Order{
    private String userAddress;

    public DeliveryOrder(){
        userAddress = "";
    }


    @Override
    public String getType(){
        return "Delivery";
    }

    public void setUserAddress(String add){
        this.userAddress = add;
    }

    public String getUserAddress(){
        return userAddress;
    }

}
