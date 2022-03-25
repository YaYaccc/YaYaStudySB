package com.yaya.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yaya.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
@TableName("account")
public interface AccountMapper extends BaseMapper<Account> {
    //@Select("select * from account")
    ArrayList<Account> findAll();



}
