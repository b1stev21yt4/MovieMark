package com.wzy.moviemark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;


//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ContextConfiguration("classpath:applicationContext.xml")
@ComponentScan(basePackages = "com.wzy.moviemark.mapper")
//@MapperScan("com.wzy.moviemark.mapper")
public class ServerApplication {
    public static void main(String[] args){
        SpringApplication.run(ServerApplication.class, args);
    }
}
