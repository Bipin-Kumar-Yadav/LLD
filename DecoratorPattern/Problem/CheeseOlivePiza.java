package DecoratorPattern.Problem;

public class CheeseOlivePiza extends CheesePizza{

    @Override
    public double getCost() {
        return super.getCost() + 50.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Olive";
    }
    
}
