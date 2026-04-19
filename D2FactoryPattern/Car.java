package D2FactoryPattern;

public class Car implements Transport{
    @Override
    public void deliver(){
        System.out.println("Delivering by car");
    }
}
