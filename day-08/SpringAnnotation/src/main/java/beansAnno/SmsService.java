package beansAnno;


import org.springframework.stereotype.Component;

@Component
public class SmsService {
    {
        System.out.println("[SMS] object created");
    }

    public SmsService(){
        System.out.println("[SMS] constructor called");
    }
    public void init(){
        System.out.println("[SMS] Init called");
    }
    public void destroy(){
        System.out.println("[SMS] Destroy called");
    }


    public void send(){
        System.out.println("through [sms]!!");
    }
}
