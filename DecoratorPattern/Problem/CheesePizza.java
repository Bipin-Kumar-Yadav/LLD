package DecoratorPattern.Problem;

public class CheesePizza extends BasicPizza{

    @Override
    public double getCost() {
        return super.getCost()+50.00;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }
    
}
