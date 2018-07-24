package com.niule.yunjiagong.yunjiagong.dal.model;

import javax.persistence.*;

@Table(name = "notice_type")
public class NoticeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型名称
     */
    private String name;

    private String impression;

    /**
     * 标准
     */
    private String standard;

    /**
     * 资源
     */
    private String source;

    /**
     * 模板
     */
    private String template;

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
     * 获取类型名称
     *
     * @return name - 类型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置类型名称
     *
     * @param name 类型名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return impression
     */
    public String getImpression() {
        return impression;
    }

    /**
     * @param impression
     */
    public void setImpression(String impression) {
        this.impression = impression == null ? null : impression.trim();
    }

    /**
     * 获取标准
     *
     * @return standard - 标准
     */
    public String getStandard() {
        return standard;
    }

    /**
     * 设置标准
     *
     * @param standard 标准
     */
    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    /**
     * 获取资源
     *
     * @return source - 资源
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置资源
     *
     * @param source 资源
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * 获取模板
     *
     * @return template - 模板
     */
    public String getTemplate() {
        return template;
    }

    /**
     * 设置模板
     *
     * @param template 模板
     */
    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }
}