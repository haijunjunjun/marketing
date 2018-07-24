package com.niule.yunjiagong.yunjiagong.dal.model;

import javax.persistence.*;

@Table(name = "sort_type")
public class SortType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 排序标志
     */
    @Column(name = "sort_sign")
    private String sortSign;

    /**
     * 排序
     */
    private String sort;

    /**
     * 内容
     */
    private String content;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取排序标志
     *
     * @return sort_sign - 排序标志
     */
    public String getSortSign() {
        return sortSign;
    }

    /**
     * 设置排序标志
     *
     * @param sortSign 排序标志
     */
    public void setSortSign(String sortSign) {
        this.sortSign = sortSign == null ? null : sortSign.trim();
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}