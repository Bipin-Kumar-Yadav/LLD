package FacadePattern.Solution;

public class UserService {
    public String getUserDetails(String userId){
        return String.format("User Details for userId %s",userId);
    }
}
