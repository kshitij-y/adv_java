package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        MessageService messageService = context.getBean(MessageService.class);
        //MessageService messageService1 = context.getBean(MessageService.class);
        messageService.sendMessage();

        context.close();

    }
}
/*
* beanFactory
* XmlbeanFactory | ApplicatoinCOntext
*
*                           |
*
* AnnotationCatalog | Classpathxml | FileSystemXml
*
* */