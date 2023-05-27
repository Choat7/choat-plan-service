package com.choat.plan.postgre.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.choat.plan.postgre.mybatisplus.entity.PostgresUserEntity;

import java.util.List;

public interface IPostgresUserService extends IService<PostgresUserEntity> {

    List<PostgresUserEntity> findUserList(PostgresUserEntity userEntity);
}