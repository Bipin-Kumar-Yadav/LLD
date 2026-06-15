package MediatorPattern.Solution;

public class User {
    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void sendMessage(String msg, User sender){
        System.out.println(sender.getName() + " is sending msg: "+ msg + " to : "+ this.name);
    }
}
