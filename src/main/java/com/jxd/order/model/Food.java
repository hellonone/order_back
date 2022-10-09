package com.jxd.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName Food
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/24
 * @Version 1.0
 */
@Data
public class Food {
    @TableId(value = "foodno",type = IdType.AUTO)
    private Integer foodno;
    private String fname;
    private Double price;
}
