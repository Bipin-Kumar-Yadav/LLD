package D2FactoryPattern.DocumentCreation;

public class Exercise {
    public static void main(String[] args) {
        Document doc = DocumentFactory.createDocument("html");
        doc.displayType();
    }
}
