package com.jxd.order.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @ClassName FoodOrderVO
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/10/4
 * @Version 1.0
 */
@Data
public class FoodOrderVO {
    @TableField(value = "order_foodno")
    private Integer orderFoodno;
    private Integer orderno;
    private Integer foodno;
    @TableField(value = "count_sum")
    private Integer count;
    private String fname;
}
