package com.lingnan.mybatisdemo.bean;


/**
 * 分页实体类
 */
public class Pager {

    private int currentPage = 1;    // 第几页
    private int pageSize = 10;      // 页的大小
    private int total;              // 记录数


    public Pager() {
    }

    public Pager(int currentPage, int pageSize, int total) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
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

        int nextPage = currentPage == this.getPages()?
                this.getPages(): currentPage + 1;
        return nextPage;
    }

    /**
     * 获取上一页
     * @return
     */
    public int getPrePage(){

        int prePage = currentPage == 1?
                currentPage: currentPage - 1;
        return prePage;
    }
}
