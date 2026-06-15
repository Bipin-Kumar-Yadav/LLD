package DecoratorPattern.Solution;

public class BasicPizza implements Pizza{

    @Override
    public double getCost() {
        
        return 50;
    }

    @Override
    public String getDescription() {
       
        return "Basic Pizza";
    }
    
}
