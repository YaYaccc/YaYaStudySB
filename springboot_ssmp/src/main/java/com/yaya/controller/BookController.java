package com.yaya.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yaya.controller.utils.R;
import com.yaya.domain.Book;
import com.yaya.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    R save(@RequestBody Book book) {
        return new R(bookService.save(book));
    }

    @DeleteMapping("{id}")
    R delete(@PathVariable Integer id) {
        return new R(bookService.deleteById(id));
    }

    @PutMapping
    R update(@RequestBody Book book) {
        return new R(bookService.modify(book));

    }

    @GetMapping("{id}")
    R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }


    @GetMapping("{currentPage}/{pageSize}")
    R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize,Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        if (currentPage > page.getPages())
            page = bookService.getPage(1, pageSize,book);
        return new R(true, page);
    }

}