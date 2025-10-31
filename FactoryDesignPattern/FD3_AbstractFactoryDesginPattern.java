package FactoryDesignPattern;

// --- Product 1 --> Burger ---
interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}
class BasicWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger with bun, patty, and ketchup!");
    }
}

class StandardWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumWheatBurger implements Burger {
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}

// --- Product 2 --> GarlicBread ---
interface GarlicBread {
    void prepare();
}

class BasicGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Basic Garlic Bread with butter and garlic!");
    }
}

class CheeseGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Cheese Garlic Bread with extra cheese and butter!");
    }
}

class BasicWheatGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Basic Wheat Garlic Bread with butter and garlic!");
    }
}

class CheeseWheatGarlicBread implements GarlicBread {
    public void prepare() {
        System.out.println("Preparing Cheese Wheat Garlic Bread with extra cheese and butter!");
    }
}

// --- Abstract Factory ---
interface MealFactory {
    Burger createBurger(String type);
    GarlicBread createGarlicBread(String type);
}

// --- Concrete Factory 1 ---
class SinghBurger implements MealFactory{
    @Override
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

    @Override
    public GarlicBread createGarlicBread(String type){
        switch(type.toLowerCase()){
            case "basic":
                return new BasicGarlicBread();
            case "cheese":
                return new CheeseGarlicBread();
            default:    
                throw new IllegalArgumentException("Unknown garlic bread type: " + type); 
        }
    }
}

// --- Concrete Factory 2 ---
class KingBurger implements MealFactory{
    @Override
    public Burger createBurger(String type){
        switch(type.toLowerCase()){
            case "basic":
                return new BasicWheatBurger();
            case "standard":
                return new StandardWheatBurger();
            case "premium":
                return new PremiumWheatBurger();
            default:    
                throw new IllegalArgumentException("Unknown burger type: " + type); 
        }
    }
    @Override
    public GarlicBread createGarlicBread(String type){
        switch(type.toLowerCase()){
            case "basic":
                return new BasicWheatGarlicBread();
            case "cheese":
                return new CheeseWheatGarlicBread();
            default:    
                throw new IllegalArgumentException("Unknown garlic bread type: " + type); 
        }
    }
}

public class FD3_AbstractFactoryDesginPattern {
    public static void main(String[] args) {
        String burgerType = "Premium";
        String garlicBreadType = "Cheese";

        MealFactory mealFactory = new SinghBurger();
        Burger burger = mealFactory.createBurger(burgerType);
        GarlicBread garlicBread = mealFactory.createGarlicBread(garlicBreadType);

        if(burger != null && garlicBread != null){
            burger.prepare();
            garlicBread.prepare();
        }
    }
}


/*
 * Here, the Abstract Factory pattern is properly implemented.
 * The MealFactory interface defines methods for creating related products (Burger and GarlicBread).
 * The SinghBurger and KingBurger classes are concrete factories that implement the MealFactory interface to create specific types of burgers and garlic breads.
 * The client code (main method) is decoupled from the concrete product classes and only interacts with the abstract factory interface.
 * This allows for easy extension of new product families (e.g., adding new types of burgers or garlic breads) without modifying existing
 */