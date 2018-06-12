package com.lingnan.mybatisdemo.bean;


import java.util.List;

/**
 * 分页实体类
 * 基于分页类进行排序等基本需求
 */
public class Pager<T> {

    private int currentPage = 1;    // 第几页
    private int pageSize = 10;      // 页的大小
    private int total;              // 记录数
    private T param;                // 条件查询参数
    private List<T> results;        // 查询结果

    public Pager() {
    }

    public Pager(int currentPage, int pageSize, int total) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
    }

    public Pager(int currentPage, int pageSize, int total, T param, List<T> results) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        this.param = param;
        this.results = results;
    }



    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage > 1)
            this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 1)
            this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        if (total > 0)
            this.total = total;
    }

    /**
     * 获取当前的页数
     * @return
     */
    public int getStartIndex(){
        return (currentPage - 1) * pageSize;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getPages(){
        return this.total % this.pageSize == 0?
                this.total / this.pageSize:
                this.total / this.pageSize + 1;
    }

    /**
     * 获取下一页
     * @return
     */
    public int getNextPage(){

        int nextPage = currentPage >= this.getPages()?
                this.getPages(): currentPage + 1;
        return nextPage;
    }

    /**
     * 获取上一页
     * @return
     */
    public int getPrePage(){

        int prePage = currentPage <= 1?
                currentPage: currentPage - 1;
        return prePage;
    }


    @Override
    public String toString() {
        return "Pager{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", total=" + total +
                '}';
    }
}
