package com.example.backend.Ajax.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.backend.Ajax.pojo.UserEntity;
import com.example.backend.Dubbo.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Ajaxcontroller {

    @Autowired
    ProviderService ProviderService;


    @GetMapping("/AjaxReq")
    public JSONObject   Demo(Long ID) {
        JSONObject json=new JSONObject();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(ID);
        json.put("user",userEntity);
        return json;
    }


    @PostMapping("/AjaxReq")
    public JSONObject Demo(@RequestBody UserEntity user) {
        JSONObject json=new JSONObject();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        json.put("user",userEntity);
        return json;

    }


}
