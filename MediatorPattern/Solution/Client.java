package MediatorPattern.Solution;

public class Client {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();
        User rahul = new User("Rahul");
        User neha = new User("Neha");
        User amit = new User("Amit");
        User karan = new User("Karan");

        chatRoom.addUser(rahul);
        chatRoom.addUser(neha);
        chatRoom.addUser(amit);
        chatRoom.addUser(karan);

        chatRoom.sendMessage("hi", amit);
    }
}
