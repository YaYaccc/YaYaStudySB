package com.yaya.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yaya.domain.Book;
import com.yaya.mapper.BookMapper;
import com.yaya.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    public Boolean deleteById(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean modify(Book book) {
        return bookMapper.updateById(book) > 0;
    }


    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
        Page<Book> page = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(book.getCountry() != null, Book::getCountry, book.getCountry());
        wrapper.like(book.getName() != null, Book::getName, book.getName());
        wrapper.like(book.getDescription() != null, Book::getDescription, book.getDescription());
        bookMapper.selectPage(page, wrapper);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        Page<Book> page = new Page<>(currentPage, pageSize);
        bookMapper.selectPage(page, null);
        return page;
    }

}