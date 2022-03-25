package com.yaya;

import com.yaya.domain.Account;
import com.yaya.enums.SexEnum;
import com.yaya.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ApplicationTest {




	@Autowired
	private AccountMapper accountMapper;

	@Test
	void contextLoads() {
		ArrayList<Account> accounts = accountMapper.findAll();
		for (Account account:accounts) System.out.println(account);
	}


	@Test
	void mpTest() {
		List<Account> accounts = accountMapper.selectList(null);
		for (Account account:accounts) System.out.println(account);
	}


	@Test
	void emumsTest() {
		System.out.println();
	}

}
