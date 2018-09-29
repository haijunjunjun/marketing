package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 12:07
 */
@Data
public class ActiveInfoModel implements Serializable {
    private static final long serialVersionUID = 6865373204163609489L;
    private Integer id;
    private String imgUrl;
}
