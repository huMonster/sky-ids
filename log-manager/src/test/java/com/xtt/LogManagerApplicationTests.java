package com.xtt;

import com.xtt.log.web.log.operationlog.entity.UserLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogManagerApplicationTests {

    @Test
    public void contextLoads() throws IllegalAccessException {
        UserLog userLog = new UserLog();
        Field[] fields = userLog.getClass().getDeclaredFields();
        Class<?> superClazz = userLog.getClass().getSuperclass();
        Field[] superFields = superClazz.getDeclaredFields();

    }

}
