package com.jxd.order.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @ClassName EmpTempVO
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/28
 * @Version 1.0
 */
@Data
public class EmpTempVO {
    private Integer empno;
    private String ename;
    private Integer sex;
    private String tel;
    private Integer job;
    private Integer deptno;
    private String dname;
    @TableField(value = "emp_orderno")
    private Integer empOrderno;
    private Integer orderno;
}
