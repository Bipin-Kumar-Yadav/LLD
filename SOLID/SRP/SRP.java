package SOLID.SRP;

import java.util.ArrayList;
import java.util.List;

class Product{
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    // public void setName(String name){
    //     this.name = name;
    // }

    public double getPrice(){
        return price;
    }

    // public void setPrice(double price){
    //     this.price = price;
    // }
}

class ShoppingCart{
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        System.out.println("Adding Product: " + p.getName());
        products.add(p);
    }
    public List<Product> getProducts(){
        return products;
    }

    public double calculateTotal(){
        double total = 0;
        for(Product p: products){
            total+=p.getPrice();
        }
        return total;
    }
}

class ShoppingCartPrinter{
    private ShoppingCart cart;

    public ShoppingCartPrinter(ShoppingCart cart){
        this.cart = cart;
    }
    
    public void printInvoice(){
        System.out.println("Invoice:");
        for(Product p: cart.getProducts()){
            System.out.println(p.getName() + ": Rs. "+p.getPrice());
        }
        System.out.println("Total: Rs. "+ cart.calculateTotal());
    }
}

class ShoppingCartStorage{
    private ShoppingCart cart;

    public ShoppingCartStorage(ShoppingCart cart){
        this.cart = cart;
    }

    public void saveToDb(){
        System.out.println("Saving to database...");
    }
}


public class SRP {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Macbook mini m4", 87000.00));
        cart.addProduct(new Product("iPhone 14", 70000.00));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        ShoppingCartStorage persistence = new ShoppingCartStorage(cart);
        persistence.saveToDb();

    }
}
