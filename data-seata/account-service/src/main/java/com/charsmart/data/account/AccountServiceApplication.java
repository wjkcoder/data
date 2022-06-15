package com.charsmart.data.account;

import com.charsmart.data.account.repository.mapper.BdAccountMapper;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Wonder
 * @Date: Created on 2022/6/6 3:16 PM
 */
@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.charsmart.data.account")
public class AccountServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class);
    }
}
