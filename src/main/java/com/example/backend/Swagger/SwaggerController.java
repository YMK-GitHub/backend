package com.example.backend.Swagger;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backend.Ajax.mapper.UserMapper;
import com.example.backend.Ajax.pojo.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "SwaggerController", description = "SwaggerDemo")
@Controller
@RequestMapping("/brand")
public class SwaggerController {
    @Autowired
    UserMapper mapper;

    @ApiOperation("查询")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public List<UserEntity> getList() {

        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        List<UserEntity> userEntities = mapper.selectList(queryWrapper);
        return userEntities;
    }

    @ApiOperation("添加")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public int create(UserEntity UserEntity) {


        return mapper.insert(UserEntity);
    }

    @ApiOperation("更新")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public int update( @RequestBody UserEntity UserEntity ) {

        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();

        return mapper.updateById(UserEntity);
    }

    @ApiOperation("删除")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public int deleteBrand(Long id) {
        return mapper.deleteById(id);

    }


}
