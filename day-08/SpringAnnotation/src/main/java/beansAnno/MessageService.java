package beansAnno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    private final EmailService emailService;
    private final SmsService smsService;

    {
        System.out.println("[Message] object created");
    }

    @Autowired
    public MessageService(EmailService emailService, SmsService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void sendMail(){
        System.out.println("[Message] is being sent!!");
        emailService.send();
    }

    public void sendSMS(){
        System.out.println("[Message] is being sent!!");
        smsService.send();
    }

    public void init(){
        System.out.println("[Message] Init called");
    }
    public void destroy(){
        System.out.println("[Message] Destroy called");
    }

}
