package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author haijun
 * @create 2018 - 08 - 17 - 14:08
 */
@Data
public class SumArrangeModel implements Serializable {
    private static final long serialVersionUID = 1018919728342425012L;
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 今日总结
     */
    @Column(name = "today_sum")
    private String todaySum;

    /**
     * 明日总结
     */
    @Column(name = "tomorrow_arrange")
    private String tomorrowArrange;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    private String createTimeV1;
}
