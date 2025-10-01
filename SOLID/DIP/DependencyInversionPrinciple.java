package SOLID.DIP;

interface Database{
    void save(String data);
}

class MySQLDatabase implements Database{
    @Override
    public void save(String data){
        System.out.println("Saving data to MySQL Database: " + data);
    }
}

class PostgreSQLDatabase implements Database{
    @Override
    public void save(String data){
        System.out.println("Saving data to PostgreSQL Database: " + data);
    }
}

class UserService{
    private final Database db;

    public UserService(Database db){
        this.db = db;
    }

    public void saveUser(String user){
        db.save(user);
    }
}
public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        MySQLDatabase mySQLDatabase = new MySQLDatabase();
        PostgreSQLDatabase postgreSQLDatabase = new PostgreSQLDatabase();
        UserService userService1 = new UserService(mySQLDatabase);
        userService1.saveUser("John Doe");
        UserService userService2 = new UserService(postgreSQLDatabase);
        userService2.saveUser("Jane Smith");
    }
}
