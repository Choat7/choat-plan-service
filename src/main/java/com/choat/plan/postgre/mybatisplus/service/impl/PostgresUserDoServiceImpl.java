package com.choat.plan.postgre.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.choat.plan.postgre.mybatisplus.dao.IPostgresUserDao;
import com.choat.plan.postgre.mybatisplus.entity.PostgresUserEntity;
import com.choat.plan.postgre.mybatisplus.service.IPostgresUserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PostgresUserDoServiceImpl extends ServiceImpl<IPostgresUserDao, PostgresUserEntity> implements IPostgresUserService {

    @Override
    public List<PostgresUserEntity> findUserList(PostgresUserEntity userEntity) {
        return baseMapper.findUserList(userEntity);
    }
}
