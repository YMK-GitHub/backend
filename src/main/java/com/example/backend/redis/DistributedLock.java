package com.example.backend.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistributedLock {

    @Autowired
    RedissonClient client;

    @GetMapping("/DistributedLock")
    public String lock() {
        String mes = "";
        RLock lock = client.getLock("锁1");


        if (lock.tryLock()) {

            mes= "分布式事务锁1Lock成功";
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else{

            mes= "分布式事务锁1Lock失败";
        }
        return mes;
    }


}
