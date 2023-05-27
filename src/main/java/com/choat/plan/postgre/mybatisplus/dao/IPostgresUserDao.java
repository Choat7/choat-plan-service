package com.choat.plan.postgre.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.choat.plan.postgre.mybatisplus.entity.PostgresUserEntity;

import java.util.List;

public interface IPostgresUserDao extends BaseMapper<PostgresUserEntity> {

    List<PostgresUserEntity> findUserList(PostgresUserEntity userEntity);
}
