package com.example.backend.Dubbo.impl;

import com.example.backend.Dubbo.ProviderService;
import com.example.backend.Fegin.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProviderService")
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    HelloFeign hellofeign;

    @Override
    public void SayHello() {
        System.out.println("访问了Dubbo");
        hellofeign.helloFeign();

    }
}
