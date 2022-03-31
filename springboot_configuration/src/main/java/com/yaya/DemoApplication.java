package com.yaya;

import com.yaya.config.ConfigTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@EnableConfigurationProperties(ConfigTest.class)
public class DemoApplication {




    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
