package com.niule.yunjiagong.yunjiagong.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 25 - 16:20
 */
@Data
public class DefaultResource implements Serializable {
    private static final long serialVersionUID = -6380829927808278576L;
    private String typeName;
    private String resourceUrl;

    public DefaultResource(String typeName, String resourceUrl) {
        this.typeName = typeName;
        this.resourceUrl = resourceUrl;
    }
}
