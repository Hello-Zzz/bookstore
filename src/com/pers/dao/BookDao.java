package com.pers.dao;

import com.pers.pojo.Book;

import java.util.List;

public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryById(Integer id);

    public List<Book> queryBooks();

    Integer queryForTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
