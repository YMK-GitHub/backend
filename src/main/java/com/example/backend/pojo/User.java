package com.example.backend.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@TableName("user")
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
