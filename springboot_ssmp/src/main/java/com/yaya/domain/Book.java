package com.yaya.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class Book {

    @TableId
    private Integer id;
    private String country;
    private String name;
    private String description;
}