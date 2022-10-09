package com.jxd.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName Emp
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/24
 * @Version 1.0
 */
@Data
public class Emp {
    @TableId(type = IdType.AUTO)
    private Integer empno;
    private String ename;
    private Integer sex;
    private String tel;
    private Integer deptno;
    private Integer job;
}
