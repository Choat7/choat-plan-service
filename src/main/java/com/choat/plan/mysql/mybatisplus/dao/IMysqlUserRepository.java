package com.choat.plan.mysql.mybatisplus.dao;

import com.choat.plan.mysql.mybatisplus.entity.MysqlUserEntity;
import com.choat.plan.mysql.mybatisplus.entity.MysqlUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IMysqlUserRepository {

    List<MysqlUserVO> findUserList(MysqlUserVO userEntity);

    int batchAdd(List<MysqlUserEntity> list);
}
