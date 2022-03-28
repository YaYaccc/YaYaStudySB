package com.yaya.service;


import com.yaya.domain.Book;
import com.yaya.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;


    @Test
    void insertTest(){
        Book book = new Book();
        book.setName("insertTest");
        book.setCountry("中国");
        book.setDescription("123");
        bookService.save(book);
    }

    @Test
    void deleteTest(){
        bookService.removeById(10);
    }

    @Test
    void getAllTest(){
        bookService.list();
    }


}