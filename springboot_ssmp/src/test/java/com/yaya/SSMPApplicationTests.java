package com.yaya;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yaya.domain.Book;
import com.yaya.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import java.util.List;

@SpringBootTest()
@AutoConfigureMockMvc
class SSMPApplicationTests {


    @Autowired
    private BookMapper bookMapper;


    // 在test模拟mvc的运行 有 @AutoConfigureMockMvc 就能用
    @Autowired
    private MockMvc mvc;

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
    void mvcTest() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books1");
        ResultActions perform = mvc.perform(builder);
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        perform.andExpect(ok);
        System.out.println(perform);
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
