package com.example.backend.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MybatisPlusApplicationTests {
    // 继承了BaseMapper，所有的方法都来自己父类 // 我们也可以编写自己的扩展方法！
//    @Autowired
//    private UserMapper userMapper;
//    @RequestMapping("/MybatisPlus/test")
//    List<User>  contextLoads() { // 参数是一个 Wrapper ，条件构造器，这里我们先不用 null
//        // 查询全部用户
//        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);
//        return users;
//    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s = new String("s");
        list.add(s);
        list.add(s);
        list.add(s);
        list.add(s);

        int seq = 0;

        try {
            for (String ss : list) {
                try {
                    seq++;
                    throw new Exception("");
                } catch (Exception e) {
                    System.out.println(seq);
                }
            }
        } catch (Exception e) {
            System.out.println(seq);
        }

    }

}
