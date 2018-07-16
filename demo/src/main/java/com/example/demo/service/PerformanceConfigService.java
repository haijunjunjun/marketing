package com.example.demo.service;

import com.example.demo.dal.mapper.*;
import com.example.demo.dal.model.PerformanceConfig;
import com.example.demo.dal.model.UserCommissions;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class PerformanceConfigService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private PerformanceConfigMapper configMapper;
    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private UserPerformanceMapper userPerformanceMapper;
    @Autowired
    private UserCommissionsMapper userCommissionsMapper;
    @Autowired
    private UserAccountMapper userAccountMapper;

    /**
     * 通过 userId 获取等级
     */
    public String getLevelCode(Integer userId) {
        if (StringUtils.isEmpty(userId.toString()) || userId <= 0) {
            log.info(" userId 参数信息异常");
            throw new BizRuntimeException(" userId 参数信息异常");
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if (Objects.isNull(userInfo) || Objects.isNull(userInfo.getLevel())) {
            log.info("用户信息查询异常!");
            throw new BizRuntimeException("用户信息查询异常！");
        }
        return userInfo.getLevel().trim();
    }

    /**
     * 通过 code 获取value
     */
    public Map<String, Object> getPerformanceConfig() {
        Map<String, Object> data = new HashMap<>();
        List<PerformanceConfig> performanceConfigs = configMapper.selectAll();
        if (Objects.isNull(performanceConfigs)) {
            log.info("数据库信息查询异常！");
            throw new BizRuntimeException("数据库信息查询异常！");
        }
        for (PerformanceConfig p : performanceConfigs) {
            data.put(p.getCode().trim(), p.getValue());
        }
        return data;
    }

    /**
     * 根据日期获得所在周的日期区间（周一和周日日期）
     *
     * @return
     * @throws ParseException
     * @author haijun
     */
    public String getTimeInterval(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        String imptimeBegin = sdf.format(cal.getTime());
        // System.out.println("所在周星期一的日期：" + imptimeBegin);
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        // System.out.println("所在周星期日的日期：" + imptimeEnd);
        return imptimeBegin + "," + imptimeEnd;
    }

    /**
     * 获取日期范围 -1上一周，0本周，1下一周
     */
    public String getWeekDays(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar1 = Calendar.getInstance();
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayOfWeek) {
            calendar1.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 获得当前日期是一个星期的第几天
        int day = calendar1.get(Calendar.DAY_OF_WEEK);
        //获取当前日期前（下）x周同星几的日期
        calendar1.add(Calendar.DATE, 7 * i);
        calendar1.add(Calendar.DATE, calendar1.getFirstDayOfWeek() - day);
        String beginDate = sdf.format(calendar1.getTime());
        calendar1.add(Calendar.DATE, 6);
        String endDate = sdf.format(calendar1.getTime());
        System.out.println(beginDate + " 到 " + endDate);
        return beginDate + "," + endDate;
    }

    /**
     * 获取开始日期与结束日期
     */
    public Map<String, String> getDt(String dt) {
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(dt)) {
            log.info("dt value is null");
            throw new BizRuntimeException("dt value is null");
        }
        String[] data = dt.trim().split(",");
        map.put("begin", data[0]);
        map.put("end", data[1]);
        return map;
    }

    /**
     * 判断该销售人员是不是新来人员
     */
    public boolean validNew(Integer userId, Date date) {
        Map<String, String> dt = this.getDt(this.getWeekDays(-2).trim());
        String endDt = dt.get("end").trim();
        Integer i = userInfoMapper.validNew(userId, endDt, DateUtil.dateStrV1(date));
        if (i > 0) {
            return true;
        }
        return false;

    }

    /**
     * 计算用户的提成
     */
    public Double calUserCommission(Integer userId) {
        if (StringUtils.isEmpty(userId.toString().trim()) || userId <= 0) {
            log.info("userId 参数异常!");
            throw new BizRuntimeException("userId 参数异常!");
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        String level = userInfo.getLevel();
        Map<String, Object> config = this.getPerformanceConfig();
        //根据等级获取当前销售员的定额
        BigDecimal quota = new BigDecimal(config.get(level).toString());
        //获取配置（提成百分比）
        BigDecimal r1 = new BigDecimal(config.get("R1").toString());
        BigDecimal r2 = new BigDecimal(config.get("R2").toString());
        BigDecimal r3 = new BigDecimal(config.get("R3").toString());
        BigDecimal r6 = new BigDecimal(config.get("R6").toString());
        //计算当前日期所在周的上一周日期区间
        Map<String, String> dtV1 = this.getDt(getWeekDays(-1));
        //计算当前用户上一周的总业绩
        BigDecimal performanceV1 = new BigDecimal(userPerformanceMapper.getPerformance(userId, dtV1.get("begin"), dtV1.get("end")));
        if (performanceV1.compareTo(BigDecimal.ZERO) == -1) {
            log.info("数据信息异常!");
            throw new BizRuntimeException("数据信息异常!");
        }
        //上周的业绩小于定额
        if (performanceV1.compareTo(quota) == -1) {
            return performanceV1.multiply(r1).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        }
        BigDecimal performanceV2;
        if (this.validNew(userId, new Date())) {
            performanceV2 = quota;
        } else {
            //计算当前日期所在周的上上周日期区间
            Map<String, String> dtV2 = this.getDt(getWeekDays(-2));
            //计算上上周的总业绩
            performanceV2 = new BigDecimal(userPerformanceMapper.getPerformance(userId, dtV2.get("begin"), dtV2.get("end")));
        }
        if ((performanceV1.compareTo(quota) == 1 || performanceV1.compareTo(quota) == 0)
                && (performanceV1.compareTo(performanceV2) == -1 || performanceV1.compareTo(performanceV2) == 0)) {
            return (quota.multiply(r2).add(performanceV1.subtract(quota).multiply(r3))).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        }
        BigDecimal r4 = r2.multiply(new BigDecimal(1).add((performanceV1.subtract(quota)).divide(performanceV1, 2, BigDecimal.ROUND_HALF_DOWN)));
        BigDecimal r5 = r3.multiply(new BigDecimal(1).add((performanceV1.subtract(quota)).divide(performanceV1, 2, BigDecimal.ROUND_HALF_DOWN)));
        if ((performanceV1.compareTo(quota) == 1 || performanceV1.compareTo(quota) == 0)
                && performanceV1.compareTo(performanceV2) == 1) {
            BigDecimal dft = quota.multiply(r4).add((performanceV1.subtract(quota)).multiply(r5));
            if (performanceV2.compareTo(quota) == 1) {
                return dft.add((performanceV1.subtract(performanceV2)).multiply(r6)).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
            }
            return dft.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        }
        return Double.parseDouble("0");
    }

    public void saveUserCommission(Integer userId, double commission) {
        UserCommissions userCommissions = new UserCommissions();
        userCommissions.setUserId(userId);
        userCommissions.setCommission(commission);
        userCommissions.setCreateTime(new Date());
        int i = userCommissionsMapper.insert(userCommissions);
        if (1 != i) {
            log.info("用户提成数据保存异常!");
            throw new BizRuntimeException("用户提成数据保存异常!");
        }
        log.info("用户提成数据保存成功!");
        //更新用户账户信息
        int updateInfo = userAccountMapper.updateUserAccount(userId, -commission);
        if (1 != updateInfo) {
            log.info("更新信息异常！");
            throw new BizRuntimeException("更新信息异常!");
        }
    }
}
