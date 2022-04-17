package com.yaya;


import com.yaya.pojo.User;
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
    private RedisTemplate redisTemplate;
    private ValueOperations valueOperations;


    @BeforeEach
    void init() {
        System.out.println("before");
    }


//    @Test
//    void set() {
//		valueOperations.set("name","丫丫");
//    }

    @Test
    void get(){
        User user = new User("丫丫",18);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
