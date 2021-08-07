package com.pers.pojo;

import java.util.List;

public class Page<T> {

    public static final Integer PAGE_SIZE = 4;
    // 当前页码---由客户端传递
    private Integer pageNo;
    // 总记录数（总图书数）
    private Integer totalCount;
    // 每个页面显式几个图书---由客户端传递
    private Integer pageSize = PAGE_SIZE;
    // 一共有多少页面
    private Integer totalPage;
    // 当前页面图书几何
    private List<T> items;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if(pageNo < 1)
            pageNo = 1;
        if(pageNo > totalPage)
            pageNo = totalPage;
        this.pageNo = pageNo;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
