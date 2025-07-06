package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryApp {
    public static void main(String[] args) {
        // ✅ Load Spring XML context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // ✅ Get the service bean (Spring has injected the repo for us)
        BookService bookService = context.getBean("bookService", BookService.class);

        // ✅ Call a method to test if DI worked
        bookService.displayBookData();
    }
}
