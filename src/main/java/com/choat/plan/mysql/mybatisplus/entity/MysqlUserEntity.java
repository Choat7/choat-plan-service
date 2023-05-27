package com.choat.plan.mysql.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@TableName(value = "user_t", autoResultMap = true)
public class MysqlUserEntity {
    @TableId
    private Long userId;
    @TableField("user_name")
    private String userName;
    @TableField("user_number")
    private String userNumber;
    @TableField("email")
    private String email;
    @TableField("created_by")
    private Long createdBy;
    @TableField("creation_date")
    private Date creationDate;
    @TableField("last_updated_by")
    private Long lastUpdatedBy;
    @TableField("last_updated_date")
    private Date lastUpdatedDate;
}
