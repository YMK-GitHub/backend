package com.example.backend.controller;

 import com.example.backend.DubboDemo.ProviderService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class controllerDemo {

    @Autowired
    ProviderService  ProviderService;


    @GetMapping("/Hello")
    public void Demo(){
         ProviderService.SayHello();

    }

}
