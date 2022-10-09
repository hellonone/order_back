package com.jxd.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName OrderFood
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/24
 * @Version 1.0
 */
@Data
@TableName(value = "order_food")
public class OrderFood {
    @TableId(value = "order_foodno", type = IdType.AUTO)
    private Integer orderFoodno;
    private Integer orderno;
    private Integer foodno;
    private Integer count;
    private Double price;
    private String note;
}
