package com.example.backend.redis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.Ajax.mapper.UserMapper;
import com.example.backend.Ajax.pojo.UserEntity;
 import com.example.backend.Common.util.RedisServiceTemplate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Api(tags = "RedisController", description = "RedisDemo")
@RestController
@RequestMapping("/Redis")
public class RedisController {

    @Autowired
    UserMapper mapper;

    @Autowired
    RedisServiceTemplate redisservice;


    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public List<UserEntity> getList() {

        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        List<UserEntity> userEntities = mapper.selectList(queryWrapper);
        return userEntities;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public int create(UserEntity UserEntity) {

        redisservice.set(UserEntity.getId().toString(),UserEntity.toString());
        return mapper.insert(UserEntity);
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public int update( @RequestBody UserEntity UserEntity ) {

        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();

        return mapper.updateById(UserEntity);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public int deleteBrand(Long id) {
        return mapper.deleteById(id);

    }


}
