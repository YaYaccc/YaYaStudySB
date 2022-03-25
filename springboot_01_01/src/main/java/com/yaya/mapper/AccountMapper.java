package com.yaya.mapper;

import com.yaya.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface AccountMapper{
    //@Select("select * from account")
    ArrayList<Account> findAll();



}
