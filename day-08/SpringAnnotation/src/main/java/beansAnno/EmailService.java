package beansAnno;


import org.springframework.stereotype.Component;

@Component
public class EmailService {
    {
        System.out.println("[Mail] object created");
    }

    public EmailService(){
        System.out.println("[Mail] constructor called");
    }
    public void init(){
        System.out.println("[Mail] Init called");
    }
    public void destroy(){
        System.out.println("[Mail] Destroy called");
    }


    public void send(){
        System.out.println("through sent!!");
    }
}
