package com.choat.plan.mysql.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.choat.plan.mysql.mybatisplus.entity.MysqlUserEntity;

import java.util.List;

public interface IMysqlUserDao extends BaseMapper<MysqlUserEntity> {

    List<MysqlUserEntity> findUserList(MysqlUserEntity userEntity);

    int batchAdd(List<MysqlUserEntity> list);
}
