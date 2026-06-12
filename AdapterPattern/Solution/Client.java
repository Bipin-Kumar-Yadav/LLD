package AdapterPattern.Solution;

public class Client {
    public static void main(String[] args) {
        NotificationService emailNotificationService = new EmailNotificationService();
        emailNotificationService.send("abc@gmail.com", "Enquiry of the product", "We would like to enquire about this particular product");

        NotificationService emailNotificationServieViaSendGrid = new SendGridAdapterService(new SendGridService());
        emailNotificationServieViaSendGrid.send("xyz@gmail.com", "Leave Application", "I would like to request a sick leave");
    }
}
