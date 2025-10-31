package FactoryDesignPattern;

// --- Burger Interface ---
interface Burger{
    void prepare();
}

// --- Concrete Burger Implementations ---
class BasicBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("Preparing Standard Burger with bun, patty, lettuce, tomato, and cheese!");
    }
}

class PremiumBurger implements Burger{
    @Override
    public void prepare(){
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}


// --- Burger Factory ---
class BurgerFactory{
    public Burger createBurger(String type){
        switch(type.toLowerCase()){
            case "basic":
                return new BasicBurger();
            case "standard":
                return new StandardBurger();
            case "premium":
                return new PremiumBurger();
            default:
                throw new IllegalArgumentException("Unknown burger type: " + type);
        }
    }
}
public class FD1_SimpleFactoryDesginPattern {
    public static void main(String[] args) {
        String type = "Basic";
        BurgerFactory myBurger = new BurgerFactory();
        Burger burger = myBurger.createBurger(type);
        
        if(burger !=null){
            burger.prepare();
        }
    }
}

/*
 Here we don't want to expose the creation logic of the burgers to the client.
    The client simply calls the factory method with the type of burger it wants,
 */