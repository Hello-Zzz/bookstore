package com.pers.test;

import com.pers.dao.BookDao;
import com.pers.dao.impl.BookDaoImpl;
import com.pers.pojo.Book;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.List;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "核心技术", "zzzzzz",
                new BigDecimal("89.9"), 23001, 1999, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(24, "核心技术III", "zzjjgg",
                new BigDecimal("89.9"), 23001, 1999, null));
    }

    @Test
    public void queryById() {
        System.out.println(bookDao.queryById(24));
    }

    @Test
    public void queryBooks() {
        for(Book queryBook: bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForTotalCount(){
        System.out.println(bookDao.queryForTotalCount());
    }

    @Test
    public void queryForPageItems(){
        for (Book book: bookDao.queryForPageItems(3, 4) )
            System.out.println(book.toString());
    }
    @Test
    public void queryForPageItemsByPrice() {
        for(Book book: bookDao.queryForPageItemsByPrice(0, 4, 10, 50)){
            System.out.println(book);
        }
    }

    @Test
    public void queryForTotalCountByPrice() {
        System.out.println(bookDao.queryForTotalCountByPrice(10, 50));
    }

}