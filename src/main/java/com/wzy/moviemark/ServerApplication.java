package com.wzy.moviemark;

import com.wzy.moviemark.config.SessionConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@MapperScan("com.wzy.moviemark.mapper")
@Import(SessionConfiguration.class)
public class ServerApplication {
    public static void main(String[] args){
        SpringApplication.run(ServerApplication.class, args);
    }
}
