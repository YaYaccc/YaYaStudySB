package com.yaya.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yaya.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookMapper extends BaseMapper<Book> {
}