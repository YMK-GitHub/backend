package com.example.backend.DubboDemo.impl;

import com.example.backend.DubboDemo.ProviderService;
import com.example.backend.FeginDemo.HelloFeign;
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
