package com.zyb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zyb.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 药品
 */
@Data
@TableName(value = "owinfo")
public class OwInfo implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String drugName;
    /*出库/入库*/
    private String type;
    /*数量*/
    private Integer count;
    /*操作人*/
    private String operator;
    /*操作时间*/
    private Date create_time;

}
