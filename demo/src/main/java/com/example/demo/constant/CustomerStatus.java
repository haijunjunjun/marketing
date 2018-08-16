package com.example.demo.constant;

public enum CustomerStatus {

    FURTHER(1, "待跟进"),
    FINISH(2, "已签约"),
    ABANDON(3, "已放弃"),
    DELETE(4, "已删除");

    private Integer status;
    private String name;

    CustomerStatus(Integer status, String name) {
        this.status = status;
        this.name = name;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
