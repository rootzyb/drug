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
@TableName(value = "druginfo")
public class DrugInfo implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /*药品名称*/
    private String name;

    /*药品名称*/
    private String supplier;

    /*生产时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productTime;

    /*保质期（月）*/
    private String warrenty;

    /*药品编码*/
    private String number;

    /*价格*/
    private Float price;

    /*库存*/
    private Integer stock;

    /*生产时间转换成年月日*/
    public String getProductTimeStr(){
        return DateUtil.dateConvert(productTime);
    }
}
