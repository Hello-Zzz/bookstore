package com.pers.service;

import com.pers.pojo.Book;
import com.pers.pojo.Page;

import java.util.List;

public interface BookService {

    public void addBook(Book book);

    public void deleteBook(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();


    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
