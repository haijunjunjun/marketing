package com.example.demo.test.page;

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
     * 上一页
     */
    private int lastPage;

    /**
     * 当前页
     */
    private int pageNum;

    /**
     * 下一页
     */
    private int nextPage;
//
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
        this.lastPage = pageNum - 1 > 1 ? pageNum - 1 : 1;
        this.nextPage = pageNum >= totalPage ? totalPage : pageNum + 1;

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

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public int getLastPage() {
        return lastPage;
    }

    public int getpageNum() {
        return pageNum;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

}
