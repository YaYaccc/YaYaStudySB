package com.yaya.domain;


import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.yaya.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
//model实现ac 但是觉得不好用
//public class Account extends Model<Account> {
public class Account{
    private String name;
    private Double money;
    @TableId
    private Integer id;
    @Version
    private Integer version = 1;
    @TableLogic
    @TableField(select = false)
    private Integer deleted;
    private SexEnum sex;
}