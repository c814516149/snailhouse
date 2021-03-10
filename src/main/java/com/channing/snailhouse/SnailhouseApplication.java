package com.channing.snailhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan({"com.channing.snailhouse.model"})
public class SnailhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnailhouseApplication.class, args);
    }

}
