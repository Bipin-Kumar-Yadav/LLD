package AdapterPattern.Solution;

public class SendGridAdapterService implements NotificationService{
    private SendGridService sendGridService;

    public SendGridAdapterService(SendGridService sendGridService){
        this.sendGridService = sendGridService;
    }

    @Override
    public void send(String to, String subject, String body){
        sendGridService.sendEmail(to, subject, body);
    }
}
