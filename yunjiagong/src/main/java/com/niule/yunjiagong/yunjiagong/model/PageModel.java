package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 08 - 29 - 17:46
 */
@Data
public class PageModel implements Serializable {
    private static final long serialVersionUID = -7328348788769401551L;
    private Integer pageNum;
    private Integer pageSize;
}
