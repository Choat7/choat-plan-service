package com.choat.plan.mysql.mybatisplus.controller;

import com.choat.plan.mysql.mybatisplus.dao.IMysqlUserRepository;
import com.choat.plan.mysql.mybatisplus.entity.MysqlUserEntity;
import com.choat.plan.mysql.mybatisplus.service.IMysqlUserService;
import com.choat.plan.postgre.mybatisplus.response.ResponseResult;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(value = "Address Interfaces", tags = "Address Interfaces")
@RestController
@RequestMapping("/mysql/user")
@Slf4j
public class MysqlUserController {

    @Autowired
    private IMysqlUserService userService;
    @Autowired
    private IMysqlUserRepository userRepository;

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
    public ResponseResult<MysqlUserEntity> add(@RequestBody MysqlUserEntity user) {
        if (user.getUserId() == null) {
            user.setCreationDate(new Date());
        }
        user.setLastUpdatedDate(new Date());
        userService.save(user);
        return ResponseResult.success();
    }
    @PostMapping("batchAdd")
    public ResponseResult<MysqlUserEntity> batchAdd(@RequestBody MysqlUserEntity user) {
        List<MysqlUserEntity> mysqlUserEntities = new ArrayList<>();
        for (int i = 0; i < 150000; i++) {
            MysqlUserEntity mysqlUserEntity = new MysqlUserEntity();
            mysqlUserEntity.setUserName(user.getUserName() + i);
            mysqlUserEntity.setUserNumber(user.getUserNumber() + i);
            mysqlUserEntity.setEmail(user.getEmail() + i);
            mysqlUserEntity.setCreatedBy(-1L);
            mysqlUserEntity.setCreationDate(new Date());
            mysqlUserEntity.setLastUpdatedBy(-1L);
            mysqlUserEntity.setLastUpdatedDate(new Date());
            mysqlUserEntities.add(mysqlUserEntity);
        }
        long startTime = System.currentTimeMillis();
//        userService.saveBatch(mysqlUserEntities);
//        userRepository.batchAdd(mysqlUserEntities);
        List<List<MysqlUserEntity>> lists = Lists.partition(mysqlUserEntities, 15000);
        for (List<MysqlUserEntity> list : lists) {
//            userService.saveBatch(list);
            userRepository.batchAdd(list);
        }
        log.debug("saveBatch>>time:{}", System.currentTimeMillis() - startTime);
        return ResponseResult.success();
    }

    /**
     * @return user list
     */
    @ApiOperation("Query User One")
    @GetMapping("edit/{userId}")
    public ResponseResult<MysqlUserEntity> edit(@PathVariable("userId") Long userId) {
//        return ResponseResult.success(userRepository.getById(userId));
        return ResponseResult.success();
    }

    /**
     * @return user list
     */
    @ApiOperation("Query User List")
    @GetMapping("list")
    public ResponseResult<List<MysqlUserEntity>> list(MysqlUserEntity userEntity) {
        return ResponseResult.success(userService.findUserList(userEntity));
    }
}
