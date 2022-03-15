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
 * 收到退货
 */
@Data
@TableName("returngoods")
public class ReturnGoods implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /*药品名称*/
    private String drugName;

    /*数量*/
    private Integer count;

    /*退货原因*/
    private String reason;

    /*总金额*/
    private Float total;

    /*操作时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatorTime;

    /*操作时间转换成年月日*/
    public String getOperateTimeStr(){
        return DateUtil.dateConvert(operatorTime);
    }
}
