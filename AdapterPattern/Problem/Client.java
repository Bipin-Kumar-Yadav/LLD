package AdapterPattern.Problem;

public class Client {
    public static void main(String[] args) {
        NotificationService notificationService = new EmailNotificationService();
        notificationService.send("xyz@gmail.com", "order confirmation", "Kindly provid the status of the placed orders.");

        //NotificationService sendGridNotificationService = new SendGrid(); --> SendGrid have different method and don't implement Notificaton Service interface
    }
}
