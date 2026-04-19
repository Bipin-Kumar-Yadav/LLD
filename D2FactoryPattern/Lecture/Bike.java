package D2FactoryPattern.Lecture;

public class Bike implements Transport{
    @Override
    public void deliver(){
        System.out.println("Delivering by bike");
    }
}
