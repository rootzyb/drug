package com.zyb.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.zyb.mapper")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInnerInterceptor(){
        PaginationInterceptor page=new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
