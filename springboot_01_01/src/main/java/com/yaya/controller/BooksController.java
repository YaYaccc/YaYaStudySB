package com.yaya.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/books")
@RestController
public class BooksController {


    @Value("${name}")
    private String name;


    @GetMapping("/hello")
    public String getHello() {
        System.out.println("springboot is running");
        return "Hello World";
    }


    @GetMapping("/test")
    public String Test() {
        System.out.println(name);
        return name;
    }

}