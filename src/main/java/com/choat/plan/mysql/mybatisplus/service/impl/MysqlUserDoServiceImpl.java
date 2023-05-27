package com.choat.plan.mysql.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.choat.plan.mysql.mybatisplus.dao.IMysqlUserDao;
import com.choat.plan.mysql.mybatisplus.entity.MysqlUserEntity;
import com.choat.plan.mysql.mybatisplus.service.IMysqlUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MysqlUserDoServiceImpl extends ServiceImpl<IMysqlUserDao, MysqlUserEntity> implements IMysqlUserService {

    @Override
    public List<MysqlUserEntity> findUserList(MysqlUserEntity userEntity) {
        return baseMapper.findUserList(userEntity);
    }

    @Override
    public int batchAdd(List<MysqlUserEntity> list) {
        return baseMapper.batchAdd(list);
    }
}
