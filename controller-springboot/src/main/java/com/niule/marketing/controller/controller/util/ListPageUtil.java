package com.niule.marketing.controller.controller.util;

import java.util.Collections;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 09 - 16:40
 */
public class ListPageUtil<T> {
    /**
     * 原集合
     */
    private List<T> data;

    /**
     * 是否是最后一页
     */
    private boolean isLastPage;

    /**
     * 当前页
     */
    private int pageNum;

//    /**
//     * 下一页
//     */
//    private int nextPage;

    /**
     * 是否是第一页
     */
    private boolean isFirstPage;

    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 总数据条数
     */
    private int totalCount;

    @Override
    public String toString() {
        return "ListPageUtil{" +
                "data=" + data +
                ", isLastPage=" + isLastPage +
                ", pageNum=" + pageNum +
                ", isFirstPage=" + isFirstPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                '}';
    }

    public ListPageUtil(){}

    public ListPageUtil(List<T> data, int pageNum, int pageSize) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("data must be not empty!");
        }

        this.data = data;
        this.pageSize = pageSize;
        /*this.totalPage = data.size()/pageSize;
        if(data.size()%pageSize!=0){
            this.totalPage++;
        }*/

        this.pageNum = pageNum;
        this.totalCount = data.size();
        this.totalPage = (totalCount + pageSize - 1) / pageSize;
        if (pageNum >= totalPage){
            this.isLastPage = true;
        }else {
            this.isLastPage = false;
        }
        if (1 == pageNum){
            this.isFirstPage = true;
        }else {
            this.isFirstPage = false;
        }
//        this.nextPage = pageNum >= totalPage ? totalPage : pageNum + 1;

    }

    /**
     * 得到分页后的数据
     *
     * @return 分页后结果
     */
    public List<T> getPagedList() {
        int fromIndex = (pageNum - 1) * pageSize;
        if (fromIndex >= data.size()) {
            return Collections.emptyList();//空数组
        }
        if (fromIndex < 0) {
            return Collections.emptyList();//空数组
        }
        int toIndex = pageNum * pageSize;
        if (toIndex >= data.size()) {
            toIndex = data.size();
        }
        return data.subList(fromIndex, toIndex);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
