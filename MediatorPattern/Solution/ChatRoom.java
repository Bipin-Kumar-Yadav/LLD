package MediatorPattern.Solution;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements ChatMediator{
    List<User> users;

    public ChatRoom(){
        this.users =  new ArrayList<>();
    }
    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String msg, User sender) {
        for(User u : users){
            if(u.getName() != sender.getName())
                u.sendMessage(msg, sender);
        }
        
    }
    
}
