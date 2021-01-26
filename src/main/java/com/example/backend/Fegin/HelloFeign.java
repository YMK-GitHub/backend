package com.example.backend.Fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "demo",fallback = HelloFeignHystrix.class,
        path ="/demo")


@RestController
public interface HelloFeign {

    @GetMapping(path = "/hello/Feign",
            produces = "application/json",
            consumes = "application/json")
    void helloFeign();

}
