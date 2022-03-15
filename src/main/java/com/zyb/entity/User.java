package com.zyb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

//用户
@Data
@TableName("user")
public class User implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
}
