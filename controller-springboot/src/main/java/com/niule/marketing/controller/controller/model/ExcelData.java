package com.niule.marketing.controller.controller.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 10 - 11 - 17:41
 */
@Data
public class ExcelData implements Serializable {
    private static final long serialVersionUID = 8370014586538378782L;
    private List<String> titles;
    private List<List<Object>> rows;
    private String name;
}
