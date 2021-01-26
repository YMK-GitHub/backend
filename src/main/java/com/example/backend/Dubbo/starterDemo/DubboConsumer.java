package com.example.backend.Dubbo.starterDemo;

import com.example.backend.Dubbo.ProviderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DubboConsumer {



        public static void main( String[] args ) throws IOException {

            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
            context.start();
            ProviderService providerService = (ProviderService) context.getBean("providerService");
              providerService.SayHello();
             System.in.read();


        }
}
