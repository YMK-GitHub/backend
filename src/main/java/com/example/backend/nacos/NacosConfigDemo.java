package com.example.backend.nacos;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NacosConfigDemo {


        @Value("${spring.application.name}")
        private String configInfo;

        @GetMapping("/configInfo")
        public String getConfigInfo() {
            return configInfo;
        }
    }


