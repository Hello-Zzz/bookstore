package com.pers.dao.impl;

import com.pers.dao.BookDao;
import com.pers.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book(`name`, `author`, `price`, `sales`, `stock`, `img_path`) " +
                "values(?, ?, ?, ?, ?, ?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(),
                book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?, `author`=?, `price`=?, `sales`=?, " +
                "`stock`=?, `img_path`=? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(),
                book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryById(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock`," +
                " `img_path` imgPath from t_book where id= ?";
        return queryForOne(sql, Book.class, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock`," +
                " `img_path` imgPath from t_book";
        return queryForList(sql, Book.class);
    }

    @Override
    public Integer queryForTotalCount() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {

        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock`," +
                " `img_path` imgPath from t_book limit ?, ?";
        return queryForList(sql, Book.class, begin, pageSize);
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock`," +
                " `img_path` imgPath from t_book where price between ? and ? order by price limit ?, ?";
        return queryForList(sql, Book.class, min, max, begin, pageSize);
    }

    @Override
    public Integer queryForTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql, min, max);
        return count.intValue();
    }
}
