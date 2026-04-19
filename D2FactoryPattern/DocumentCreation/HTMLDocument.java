package D2FactoryPattern.DocumentCreation;

public class HTMLDocument implements Document {
    @Override
    public void displayType() {
        System.out.println("This is an HTML Document.");
    }
    
}
