package com.choat.plan.postgre.mybatisplus.controller;

import com.choat.plan.postgre.mybatisplus.entity.PostgresUserEntity;
import com.choat.plan.postgre.mybatisplus.response.ResponseResult;
import com.choat.plan.postgre.mybatisplus.service.IPostgresUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Api(value = "Address Interfaces", tags = "Address Interfaces")
@RestController
@RequestMapping("/user")
public class PostgresUserController {

    @Autowired
    private IPostgresUserService userService;

    /**
     * @param user user param
     * @return user
     */
    @ApiOperation("Add/Edit User")
    @PostMapping("add")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", type = "body", dataTypeClass = String.class, required = true),
            @ApiImplicitParam(name = "email", type = "body", dataTypeClass = String.class, required = true)
    })
    public ResponseResult<PostgresUserEntity> add(@RequestBody PostgresUserEntity user) {
        if (user.getUserId() == null) {
            user.setCreationDate(new Date());
        }
        user.setLastUpdateDate(new Date());
        userService.save(user);
        return ResponseResult.success(userService.getById(user.getUserId()));
    }


    /**
     * @return user list
     */
    @ApiOperation("Query User One")
    @GetMapping("edit/{userId}")
    public ResponseResult<PostgresUserEntity> edit(@PathVariable("userId") Long userId) {
        return ResponseResult.success(userService.getById(userId));
    }

    /**
     * @return user list
     */
    @ApiOperation("Query User List")
    @GetMapping("list")
    public ResponseResult<List<PostgresUserEntity>> list(PostgresUserEntity userEntity) {
        return ResponseResult.success(userService.findUserList(userEntity));
    }
}
