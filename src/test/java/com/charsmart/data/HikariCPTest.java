package com.charsmart.data;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: Wonder
 * @Date: Created on 2021/12/31 上午11:01
 */
public class HikariCPTest {
    @Test
    public void test() {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setPoolName("HikariCP 连接池");
        hikariConfig.setJdbcUrl("jdbc:mysql://39.98.36.134:22100/aps-dev");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("shac");
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setMaximumPoolSize(15);
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        try {
            int count = 5;
            while (count > 0) {

                try (Connection conn = dataSource.getConnection(); Statement stmt = conn.createStatement();) {
                    System.out.println(conn);
                    ResultSet resultSet = stmt.executeQuery("select user_name from sys_user limit 1");
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("user_name"));
                    }
                    resultSet.close();
                }
                count--;
            }

        } catch (Exception e) {

        }
    }
}
