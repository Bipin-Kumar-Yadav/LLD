package MediatorPattern.Solution;

public interface ChatMediator {
    void sendMessage(String msg, User recipient);
    void addUser(User user);
} 
