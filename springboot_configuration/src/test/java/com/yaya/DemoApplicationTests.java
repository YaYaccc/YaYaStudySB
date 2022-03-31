package com.yaya;

import com.yaya.config.ConfigTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ConfigTest configTest;

	@Test
	void contextLoads() {
		System.out.println(configTest);
	}

}
