package com.choat.plan.mysql.mybatisplus.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class MysqlUserVO {
    private Long userId;
    private String userName;
    private String userNumber;
    private String email;
    private Long createdBy;
    private Date creationDate;
    private Long lastUpdatedBy;
    private Date lastUpdatedDate;
}
