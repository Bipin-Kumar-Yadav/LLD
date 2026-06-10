package ProxyPattern.Problem;

public class Client {
    public static void main(String[] args) {
        Image img = new RealImage("Dog.png");
        img.display();
    }
}
