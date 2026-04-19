package D2FactoryPattern;

public class Bike implements Transport{
    @Override
    public void deliver(){
        System.out.println("Delivering by bike");
    }
}
