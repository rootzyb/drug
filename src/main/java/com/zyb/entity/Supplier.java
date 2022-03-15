package com.zyb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//供应商
@Data
@TableName("supplier")
public class Supplier implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String content;
    private Date createTime;

}
