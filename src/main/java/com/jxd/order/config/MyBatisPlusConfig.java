package com.jxd.order.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyBatisPlusConfig
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/16
 * @Version 1.0
 */
// 利用当前这个类创建一个分页插件对象
@Configuration
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor getMybatisPlusInterceptor() {
        // 创建插件对象，并return到spring容器中
        // 插件集合对象
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // 创建分页插件，并指定要适配的数据库
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        // 将分页插件放到插件集合中
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mybatisPlusInterceptor;
    }
}
