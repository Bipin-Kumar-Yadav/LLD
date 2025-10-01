package SOLID.LSPRule.MethodRule.PreCondition;

// A Precondition must be statisfied before a method can be executed.
// Sub classes can weaken the precondition but cannot strengthen it.

class User{
    // Precondition:  password length should be at least 8 characters
    public void setPassword(String password){
        if(password.length() < 8){
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
        System.out.println("Password set successfully.");
    }
}

class AdminUser extends User{
     // Precondition: Password must be at least 6 characters
    @Override
    public void setPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long!");
        }
        System.out.println("Password set successfully");
    }
}
public class PreCondition {
    public static void main(String[] args) {
        User user = new AdminUser();
        user.setPassword("admin1"); // Valid for AdminUser but invalid for User
    }
}
