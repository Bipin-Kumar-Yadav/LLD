package D1SingletonPattern.Lecture;

public class AppSettings {
    // Step 1: Create a private static variable to hold the single instance of the class
    private static AppSettings instance;

    private String databaseUrl;
    private String apiKey;

  // Step 2 : constructor is private to prevent instantiation from outside the class
    private AppSettings(){
        databaseUrl = "jdbc:mysql://localhost:3306/mydb";
        apiKey = "12345-ABCDE";
    }

    // Step 3: Provide a public static method to get the instance of the class
    public static AppSettings getInstance(){
        if(instance == null){
            instance = new AppSettings();
        } 
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }
}
