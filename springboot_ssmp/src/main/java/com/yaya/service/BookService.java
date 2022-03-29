package com.yaya.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yaya.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService extends IService<Book> {
    Boolean deleteById(Integer id);

    Boolean modify(Book book);

    IPage<Book> getPage(int currentPage, int pageSize, Book book);
    IPage<Book> getPage(int currentPage, int pageSize);
}
