package com.yaya;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaya.domain.Book;
import com.yaya.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SSMPApplicationTests {


    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
        bookMapper.selectList(null);
    }


    @Test
    void insertTest() {
        Book book = new Book();
        book.setName("三体");
        bookMapper.insert(book);
    }


    @Test
    void testPage() {
        IPage page = new Page(2, 5);
        List records = page.getRecords();
        IPage iPage = bookMapper.selectPage(page, null);
        System.out.println(iPage.getRecords());
    }

    @Test
    void likePage() {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Book::getName,"三");
        wrapper.eq(Book::getId,1);
        bookMapper.selectList(wrapper);
    }

}
