package com.jxd.order.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName EmpOrder
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/28
 * @Version 1.0
 */
@Data
public class EmpOrder {
    @TableId(value = "emp_orderno")
    private Integer empOrderno;
    private Integer empno;
    private Integer orderno;
    private Integer deptno;
}
