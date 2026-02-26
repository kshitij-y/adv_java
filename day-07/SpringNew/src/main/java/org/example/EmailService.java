package org.example;

public class EmailService {

    {
        System.out.println("Object Created of EmailService");
    }

    public EmailService(){
        System.out.println("Mail constructor called");
    }
    public void init(){
        System.out.println("Mail Init called");
    }
    public void destroy(){
        System.out.println("Mail Destroy called");
    }


    public void send(){
        System.out.println("through sent!!");
    }
}
