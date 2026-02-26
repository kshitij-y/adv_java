package org.example;

import beansAnno.AppConfig;
import beansAnno.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Beans through Annotations
 *
 */
public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MessageService messageService = context.getBean(MessageService.class);

        messageService.sendMail();
        messageService.sendSMS();
    }
}
