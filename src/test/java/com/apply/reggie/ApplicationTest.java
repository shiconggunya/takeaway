package com.apply.reggie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1(){
        redisTemplate.opsForValue().set("b","beijing");
    }

}
