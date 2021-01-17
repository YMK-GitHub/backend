package com.example.backend.FeginDemo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("fallback/demo/api")
public class HelloFeignHystrix implements HelloFeign {
    @Override
    public void helloFeign() {
        System.out.println("超时了");
    }
}
