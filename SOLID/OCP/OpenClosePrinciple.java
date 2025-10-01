package SOLID.OCP;

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
            System.out.println("Product: " + p.getName() + " Price: " + p.getPrice());
        }
        System.out.println("Total: " + cart.calculateTotal());
    }
}

interface Persistence{
    void save(ShoppingCart cart);
}

class SQLPersistence implements Persistence{
    @Override
    public void save(ShoppingCart cart){
        System.out.println("Saving cart into SQL Database...");
    }
}

class PostgreSQLPersistence implements Persistence{
    @Override
    public void save(ShoppingCart cart){
        System.out.println("Saving cart into PostgreSQL Database...");
    }
}

class FilePersistence implements Persistence{
    @Override
    public void save(ShoppingCart cart){
        System.out.println("Saving cart into File...");
    }
}

public class OpenClosePrinciple{
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Bag", 3000.0));
        cart.addProduct(new Product("Shoes", 4000.0));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        Persistence sql = new SQLPersistence();
        Persistence postgres = new PostgreSQLPersistence();
        Persistence file = new FilePersistence();

        sql.save(cart);
        postgres.save(cart);
        file.save(cart);
    }
}