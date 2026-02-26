package org.example;

public class MessageService {
    private final EmailService emailService;

    {
        System.out.println("Object Created of MessageService");
    }

    public MessageService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendMessage(){
        System.out.println("Message is being sent!!");
        emailService.send();
    }
}
