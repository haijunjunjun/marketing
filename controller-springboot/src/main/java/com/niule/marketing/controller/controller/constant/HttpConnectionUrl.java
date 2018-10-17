package com.niule.marketing.controller.controller.constant;

/**
 * @author haijun
 * @create 2018 - 08 - 31 - 17:26
 */
public enum HttpConnectionUrl {

    YUNJIAGONG("http://service.yunjg.net");

    private String url;

    public String getUrl() {
        return url;
    }

    HttpConnectionUrl(String url) {

        this.url = url;
    }
}
