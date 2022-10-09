package com.jxd.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName Order
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/24
 * @Version 1.0
 */
@Data
public class Order {
    @TableId(value = "orderno", type = IdType.AUTO)
    private Integer orderno;
    private String time;
    private Integer applyno;
    private Integer type;
    private Integer count;
    private Double sum;
    private Integer status;
    private String note;
}
