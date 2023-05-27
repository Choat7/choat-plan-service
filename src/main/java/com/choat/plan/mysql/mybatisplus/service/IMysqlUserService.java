package com.choat.plan.mysql.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.choat.plan.mysql.mybatisplus.entity.MysqlUserEntity;

import java.util.List;

public interface IMysqlUserService extends IService<MysqlUserEntity> {

    List<MysqlUserEntity> findUserList(MysqlUserEntity userEntity);

    int batchAdd(List<MysqlUserEntity> list);
}
