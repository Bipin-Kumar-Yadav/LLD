package MediatorPattern.Problem;

public class User {
    private String name;

    public User(String name){
        this.name = name;
    }

    public void sendMessage(String msg,User recipient){
        System.out.println(this.name+ "sending message: " + msg + "to "+ recipient.getName() );
    }

    public String getName(){
        return this.name;
    }
}
