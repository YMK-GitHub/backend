package com.example.backend.Dubbo.controller;

 import com.example.backend.Dubbo.ProviderService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Autowired
    ProviderService  ProviderService;


    @GetMapping("/Hello")
    public void Demo(){
         ProviderService.SayHello();

    }


}
