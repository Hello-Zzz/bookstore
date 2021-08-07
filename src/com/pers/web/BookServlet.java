package com.pers.web;

import com.pers.pojo.Book;
import com.pers.pojo.Page;
import com.pers.service.BookService;
import com.pers.service.impl.BookServiceImpl;
import com.pers.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());

        bookService.updateBook(book);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("gbk");

        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0) + 1;

        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());
//        for(Map.Entry<String, String[]> entry: req.getParameterMap().entrySet())
//            System.out.println("entry: " + entry);
        bookService.addBook(book);

//        这里之所以没有用请求转发 是因为请求转发在按下F5时会有bug
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        bookService.deleteBook(id);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }

    protected void bookList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        //根据id查找图书
        Book book = bookService.queryBookById(id);
        //更新图书
//        bookService.updateBook(book);
        req.setAttribute("book", book);

        //请求转发到book_edit.jsp
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);

    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 获取请求参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        // 2 调用BookService.page(pageNo, pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        // 3 保存Page到Request中
        req.setAttribute("page", page);
        // 4 请求转发到book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }
}
