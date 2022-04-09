package com.yaya;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringbootRediusApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;
    private ValueOperations valueOperations;


    @BeforeEach
    void init() {
        System.out.println("before");
    }


    @Test
    void set() {
		valueOperations.set("name","丫丫");
    }

    @Test
    void get(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        //ops.set("name","丫丫");
        String name = ops.get("name");
        System.out.println(name);
    }

}
