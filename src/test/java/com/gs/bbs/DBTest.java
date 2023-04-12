package com.gs.bbs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@Slf4j
public class DBTest {

    @Autowired
    DataSource dataSource;

    @Test
    @DisplayName("My Sql 연결 테스트")
    public void mySQLConnection()throws Exception{

        try (Connection con = dataSource.getConnection()) {
            log.info("MySQL Connection Success :" + con.toString());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
