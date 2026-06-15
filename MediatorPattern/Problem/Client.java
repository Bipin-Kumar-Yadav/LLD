package MediatorPattern.Problem;

public class Client {
    public static void main(String[] args) {
        User rahul = new User("Rahul");
        User amit = new User("Amit");
        User neha = new User("Neha");
        User karan = new User("Karan");

        rahul.sendMessage("Hi", amit);
        rahul.sendMessage("HI", neha);
        rahul.sendMessage("Hi", karan);
        
    }
}
