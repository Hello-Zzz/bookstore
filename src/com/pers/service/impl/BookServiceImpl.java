package com.pers.service.impl;

import com.pers.dao.BookDao;
import com.pers.dao.impl.BookDaoImpl;
import com.pers.pojo.Book;
import com.pers.pojo.Page;
import com.pers.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);

        Integer totalCount = bookDao.queryForTotalCount();
        page.setTotalCount(totalCount);

        Integer totalPage =  totalCount % pageSize > 0 ? totalCount / pageSize + 1: totalCount/pageSize;
        page.setTotalPage(totalPage);


        page.setPageNo(pageNo);
        pageNo = page.getPageNo();
//        System.out.println("pageNo=" + pageNo);

        int begin = (pageNo - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(items);


        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        page.setPageSize(pageSize);

        Integer totalCount = bookDao.queryForTotalCountByPrice(min, max);
        page.setTotalCount(totalCount);

        Integer totalPage =  totalCount % pageSize > 0 ? totalCount / pageSize + 1: totalCount/pageSize;
        page.setTotalPage(totalPage);


        page.setPageNo(pageNo);
        pageNo = page.getPageNo();
//        System.out.println("pageNo=" + pageNo);

        int begin = (pageNo - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        page.setItems(items);


        return page;
    }
}
