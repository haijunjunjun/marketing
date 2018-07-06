package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageInfo<T> implements Serializable {
    private static final long serialVersionUID = 7051845635899010764L;

    private T data;
    private String content;
}
