package com.example.backend.Ajax.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import com.example.backend.Ajax.pojo.UserEntity;
import org.apache.ibatis.annotations.Mapper;
// 在对应的Mapper上面继承基本的类 BaseMapper
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {


    // 所有的CRUD操作都已经编写完成了 // 你不需要像以前的配置一大堆文件了！

}
