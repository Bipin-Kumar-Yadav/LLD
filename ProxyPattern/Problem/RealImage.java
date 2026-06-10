package ProxyPattern.Problem;

public class RealImage implements Image {
    
    private String filename;

    public RealImage(String filename){
        this.filename = filename;

        loadImageFromDisk();
    }

    private void loadImageFromDisk(){
        System.out.print("Loading image from disk "+filename);
    }
    @Override
    public void display(){
        System.out.println("Displaying image "+filename);
    }
}
