package cn.yfkj.wxapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"cn.yfkj.wxapp"})
@MapperScan(basePackages = {"cn.yfkj.wxapp.dao"})
@EnableAutoConfiguration
public class WxappApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxappApplication.class, args);
    }

}
