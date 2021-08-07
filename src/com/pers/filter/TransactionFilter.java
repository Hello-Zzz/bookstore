package com.pers.filter;

import com.pers.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);

            JdbcUtils.commitAndClose();
        } catch (Exception e) {

            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e); // 将异常抛给服务器 展示友好界面
        }
    }

    @Override
    public void destroy() {

    }
}
