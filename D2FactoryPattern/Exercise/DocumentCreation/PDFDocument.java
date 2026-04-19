package D2FactoryPattern.Exercise.DocumentCreation;

public class PDFDocument implements Document{
    @Override
    public void displayType() {
        System.out.println("This is a PDF Document.");
    }
}
