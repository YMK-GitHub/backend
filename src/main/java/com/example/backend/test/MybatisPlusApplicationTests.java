package com.example.backend.test;

import com.example.backend.mapper.UserMapper;
import com.example.backend.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisPlusApplicationTests {
    // 继承了BaseMapper，所有的方法都来自己父类 // 我们也可以编写自己的扩展方法！
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/MybatisPlus/test")
    List<User>  contextLoads() { // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
        // 查询全部用户
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        return users;
    }
}
