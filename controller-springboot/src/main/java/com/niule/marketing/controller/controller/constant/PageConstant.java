package com.niule.marketing.controller.controller.constant;

import com.niule.marketing.controller.controller.util.ListPageUtil;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 10 - 17 - 10:29
 */
public class PageConstant<T> {

    public ListPageUtil getPageInfo(List<T> data, Integer pageNum, Integer pageSize) {
        ListPageUtil<T> tListPageUtil = new ListPageUtil<>(data, pageNum == null ? 1 : pageNum, pageSize == null ? 10 : pageSize);
        tListPageUtil.setData(tListPageUtil.getPagedList());
        return tListPageUtil;
    }
}
