package ProxyPattern.Solution;

public class Client {
    

    public static void main(String[] args) {
        Image img1 = new ProxyImage("dog.png");
        Image img2 = new ProxyImage("cat.png");
        img1.display(); // this will create, load, and then display
        img1.display(); // this display alread created and loaded image
    }
}
