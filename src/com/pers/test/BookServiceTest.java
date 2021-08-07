package com.pers.test;

import com.pers.pojo.Book;
import com.pers.pojo.Page;
import com.pers.service.BookService;
import com.pers.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book( null, "平凡的世界", "路遥",
                new BigDecimal(39), 2991, 1002, null));
    }

    @Test
    public void deleteBook() {
        bookService.deleteBook(25);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book( 25, "平凡de世界", "路遥",
                new BigDecimal(39), 2991, 1002, null));
    }

    @Test
    public void queryBookById() {
        System.out.println( bookService.queryBookById(25));
    }

    @Test
    public void queryBooks() {
        for(Book book: bookService.queryBooks()){
            System.out.println(book);
        }
    }

    @Test
    public void page() {
        for(Book book: bookService.page(3, 4).getItems())
            System.out.println(book);
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(0, 4, 10, 50));

    }
}