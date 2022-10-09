package com.jxd.order.dto;

import lombok.Data;

/**
 * @ClassName OrderQueryDTO
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/28
 * @Version 1.0
 */
@Data
public class OrderQueryDTO {
    private String timeStart;
    private String timeEnd;
    private String ename;
    private Double sumStart;
    private Double sumEnd;
    private Long currPage;
    private Long limit;
    private Integer applyno;
    private Integer deptno;
    private Integer status;
    private Integer orderno;
}
