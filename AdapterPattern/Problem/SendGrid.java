package AdapterPattern.Problem;

public class SendGrid {
    public void sendEmail(String recipient, String title, String content){
        System.out.println("Sending email via sendgrid to: "+recipient);
        System.out.println("Title: "+ title);
        System.out.println("Content: "+content);
    }
}
