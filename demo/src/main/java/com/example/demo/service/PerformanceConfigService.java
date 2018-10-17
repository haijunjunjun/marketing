package com.example.demo.service;

import com.example.demo.dal.mapper.*;
import com.example.demo.dal.model.*;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.DateUtil;
import com.example.demo.util.MessageInfo;
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
    @Autowired
    private PerformanceConfigV1Mapper performanceConfigV1Mapper;

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
     * 计算用户的提成（浮动比例算法）
     */
    public Double calUserCommission(Integer userId) {
        if (StringUtils.isEmpty(userId.toString().trim()) || userId <= 0) {
            log.info("userId 参数异常!");
            throw new BizRuntimeException("userId 参数异常!");
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if (!Objects.isNull(userInfo)) {
            String level = userInfo.getLevel();
            if (StringUtils.isEmpty(level)) {
                log.info("level 等级信息为空");
                throw new BizRuntimeException("level 等级信息为空");
            }
            if (1 == userInfo.getStatus()) {
                if (1 == userInfo.getRoleId()) {
                    PerformanceConfigV1 performanceConfigV1 = new PerformanceConfigV1();
                    performanceConfigV1.setLevel(level);
                    PerformanceConfigV1 performanceConfigData = performanceConfigV1Mapper.selectOne(performanceConfigV1);
                    BigDecimal kpi = new BigDecimal(Double.toString(performanceConfigData.getKpi())).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    BigDecimal deathLine = new BigDecimal(Double.toString(performanceConfigData.getDeathLine())).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    if (Objects.isNull(performanceConfigData)) {
                        log.info("performanceConfigData 信息查询异常！");
                        throw new BizRuntimeException("performanceConfigData 信息查询异常!");
                    }
                    //计算当前日期所在周的上一周日期区间
                    Map<String, String> dtV1 = this.getDt(getWeekDays(-1));
                    //计算当前用户上一周的总业绩
                    Double data = userPerformanceMapper.getPerformance(userId, dtV1.get("begin"), dtV1.get("end")) == null ? 0 : userPerformanceMapper.getPerformance(userId, dtV1.get("begin"), dtV1.get("end"));
                    BigDecimal performanceV1 = new BigDecimal(data.toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    //上周业绩 < 生死线
                    if (performanceV1.compareTo(deathLine) == -1) {
//                        Integer remove = userInfoMapper.remove(userId);
//                        if (1 != remove) {
//                            log.info("信息移除异常！");
//                            throw new BizRuntimeException("信息移除异常!");
//                        }
                        return Double.parseDouble("-1");
                    }
                    //上周业绩 >= 生死线 && 上周业绩 < kpi
                    if ((performanceV1.compareTo(deathLine) == 1 || performanceV1.compareTo(deathLine) == 0)
                            && performanceV1.compareTo(kpi) == -1) {
                        return performanceV1.multiply(new BigDecimal("0.05")).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                    }
                    //上周业绩 >= kpi && 上周业绩 < 150%kpi
                    if ((performanceV1.compareTo(kpi) == 1 || performanceV1.compareTo(kpi) == 0)
                            && performanceV1.compareTo(kpi.multiply(new BigDecimal("1.5")).setScale(2, BigDecimal.ROUND_HALF_DOWN)) == -1) {
                        return performanceV1.multiply(new BigDecimal("0.1")).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                    }
                    //上周业绩 >= 150%kpi && 上周业绩 < 200%kpi
                    BigDecimal v1 = kpi.multiply(new BigDecimal("1.5")).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    BigDecimal v2 = kpi.multiply(new BigDecimal("2")).setScale(2, BigDecimal.ROUND_HALF_DOWN);
                    if ((performanceV1.compareTo(v1) == 1 || performanceV1.compareTo(v1) == 0)
                            && performanceV1.compareTo(v2) == -1) {
                        return performanceV1.multiply(new BigDecimal("0.12")).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                    }
                    //上周业绩 >= 200%kpi
                    if (performanceV1.compareTo(v2) == 1 || performanceV1.compareTo(v2) == 0) {
                        return performanceV1.multiply(new BigDecimal("0.15")).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                    }
                } else if (2 == userInfo.getRoleId() && -1 != userInfo.getManageId()) {
                    List<UserInfo> userInfoList = this.getUserInfoList(1, userInfo.getId());
                    double sumPerformance = this.calPerformance(userInfoList);
                    return new BigDecimal(Double.toString(sumPerformance)).multiply(new BigDecimal("0.02")).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                } else if (2 == userInfo.getRoleId() && -1 == userInfo.getManageId()) {
                    double managerPerformance = 0.00;
                    double marketPerformance = 0.00;
                    List<UserInfo> userInfoList = this.getUserInfoList(1, userInfo.getId());
                    if (!Objects.isNull(userInfoList)) {
                        managerPerformance = this.calPerformance(userInfoList);
                        for (UserInfo userInfo1 : userInfoList) {
                            List<UserInfo> userInfoList2 = this.getUserInfoList(1, userInfo1.getId());
                            double v = this.calPerformance(userInfoList2);
                            marketPerformance = new BigDecimal(Double.toString(marketPerformance))
                                    .add(new BigDecimal(Double.toString(v)))
                                    .setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                        }
                    }
                    double finalPerformance = new BigDecimal(Double.toString(managerPerformance))
                            .add(new BigDecimal(Double.toString(marketPerformance)))
                            .setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                    return new BigDecimal(Double.toString(finalPerformance))
                            .multiply(new BigDecimal("0.03"))
                            .setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                }
            }
        }
        return null;
    }

    /**
     * 通过userInfo 信息计算业绩
     */
    private double calPerformance(List<UserInfo> userInfoList) {
        double sumPerformance = 0.00;
        if (!Objects.isNull(userInfoList)) {
            for (UserInfo u1 : userInfoList) {
                UserPerformance userPerformance = new UserPerformance();
                userPerformance.setUserId(u1.getId());
                List<UserPerformance> userPerformanceList = userPerformanceMapper.select(userPerformance);
                if (!Objects.isNull(userPerformanceList)) {
                    for (UserPerformance userPerformance1 : userPerformanceList) {
                        sumPerformance = new BigDecimal(Double.toString(sumPerformance))
                                .add(new BigDecimal(userPerformance1.getPerformance().toString()))
                                .setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                    }
                }
            }
        }
        return sumPerformance;
    }

    /**
     * 通过status 与 manageId 来查询 userInfoList
     */
    private List<UserInfo> getUserInfoList(Integer status, Integer manageId) {
        UserInfo u = new UserInfo();
        u.setStatus(status);
        u.setManageId(manageId);
        List<UserInfo> userInfoList = userInfoMapper.select(u);
        return userInfoList;
    }

//    /**
//     * 计算用户的提成（浮动比例算法）
//     */
//    public Double calUserCommission(Integer userId) {
//        if (StringUtils.isEmpty(userId.toString().trim()) || userId <= 0) {
//            log.info("userId 参数异常!");
//            throw new BizRuntimeException("userId 参数异常!");
//        }
//        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
//        String level = userInfo.getLevel();
//        Map<String, Object> config = this.getPerformanceConfig();
//        //根据等级获取当前销售员的定额
//        BigDecimal quota = new BigDecimal(config.get(level).toString());
//        //获取配置（提成百分比）
//        BigDecimal r1 = new BigDecimal(config.get("R1").toString());
//        BigDecimal r2 = new BigDecimal(config.get("R2").toString());
//        BigDecimal r3 = new BigDecimal(config.get("R3").toString());
//        BigDecimal r6 = new BigDecimal(config.get("R6").toString());
//        //计算当前日期所在周的上一周日期区间
//        Map<String, String> dtV1 = this.getDt(getWeekDays(-1));
//        //计算当前用户上一周的总业绩
//        BigDecimal performanceV1 = new BigDecimal(userPerformanceMapper.getPerformance(userId, dtV1.get("begin"), dtV1.get("end")));
//        if (performanceV1.compareTo(BigDecimal.ZERO) == -1) {
//            log.info("数据信息异常!");
//            throw new BizRuntimeException("数据信息异常!");
//        }
//        //上周的业绩小于定额
//        if (performanceV1.compareTo(quota) == -1) {
//            return performanceV1.multiply(r1).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
//        }
//        BigDecimal performanceV2;
//        if (this.validNew(userId, new Date())) {
//            performanceV2 = quota;
//        } else {
//            //计算当前日期所在周的上上周日期区间
//            Map<String, String> dtV2 = this.getDt(getWeekDays(-2));
//            //计算上上周的总业绩
//            performanceV2 = new BigDecimal(userPerformanceMapper.getPerformance(userId, dtV2.get("begin"), dtV2.get("end")));
//        }
//        if ((performanceV1.compareTo(quota) == 1 || performanceV1.compareTo(quota) == 0)
//                && (performanceV1.compareTo(performanceV2) == -1 || performanceV1.compareTo(performanceV2) == 0)) {
//            return (quota.multiply(r2).add(performanceV1.subtract(quota).multiply(r3))).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
//        }
//        BigDecimal r4 = r2.multiply(new BigDecimal(1).add((performanceV1.subtract(quota)).divide(performanceV1, 2, BigDecimal.ROUND_HALF_DOWN)));
//        BigDecimal r5 = r3.multiply(new BigDecimal(1).add((performanceV1.subtract(quota)).divide(performanceV1, 2, BigDecimal.ROUND_HALF_DOWN)));
//        if ((performanceV1.compareTo(quota) == 1 || performanceV1.compareTo(quota) == 0)
//                && performanceV1.compareTo(performanceV2) == 1) {
//            BigDecimal dft = quota.multiply(r4).add((performanceV1.subtract(quota)).multiply(r5));
//            if (performanceV2.compareTo(quota) == 1) {
//                return dft.add((performanceV1.subtract(performanceV2)).multiply(r6)).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
//            }
//            return dft.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
//        }
//        return Double.parseDouble("0");
//    }

    //计算用户提成并保存到数据库
    public void saveUserCommission(Integer userId) {
        Double commission = this.calUserCommission(userId);
        if (commission == null) {
            log.info("系统信息异常!");
            return;
        }
        double v = Double.parseDouble("-1");
        if (new BigDecimal(commission.toString()).compareTo(new BigDecimal(Double.toString(v))) == 0) {
            log.info("该用户已被禁用");
            return;
        }
        UserCommissions userCommissions = new UserCommissions();
        userCommissions.setUserId(userId);
        userCommissions.setCommission(commission);
        userCommissions.setCreateTime(new Date());
        int i = userCommissionsMapper.insert(userCommissions);
        if (1 != i) {
            log.info("用户" + userId + "提成数据保存异常!");
//            throw new BizRuntimeException("用户" + userId + "提成数据保存异常!");
        }
//        log.info("用户提成数据保存成功!");
        //更新用户账户信息
        int updateInfo = userAccountMapper.updateUserAccount(userId, commission);
        if (1 != updateInfo) {
            log.info("用户" + userId + "更新信息异常！");
//            throw new BizRuntimeException("用户" + userId + "更新信息异常!");
        }
    }

    //计算提成（用户自己进行调用的接口）
    public MessageInfo<Double> calCommission(Integer userId, Integer preWeekPerformanceV1, Integer preWeekPerformanceV2) {
        MessageInfo<Double> messageInfo = new MessageInfo<>();
        if (preWeekPerformanceV1 < 0 || preWeekPerformanceV2 < 0) {
            log.info("非法参数");
            messageInfo.setContent("非法参数");
            return messageInfo;
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

        BigDecimal performanceV1 = new BigDecimal(preWeekPerformanceV1);
        BigDecimal performanceV2 = new BigDecimal(preWeekPerformanceV2);

        //上周的业绩小于定额
        if (performanceV1.compareTo(quota) == -1) {
            messageInfo.setData(performanceV1.multiply(r1).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue());
            messageInfo.setContent("success");
            return messageInfo;
        }
        if (this.validNew(userId, new Date())) {
            performanceV2 = quota;
        }
        if ((performanceV1.compareTo(quota) == 1 || performanceV1.compareTo(quota) == 0)
                && (performanceV1.compareTo(performanceV2) == -1 || performanceV1.compareTo(performanceV2) == 0)) {
            messageInfo.setData((quota.multiply(r2).add(performanceV1.subtract(quota).multiply(r3))).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue());
            messageInfo.setContent("success");
            return messageInfo;
        }
        BigDecimal r4 = r2.multiply(new BigDecimal(1).add((performanceV1.subtract(quota)).divide(performanceV1, 2, BigDecimal.ROUND_HALF_DOWN)));
        BigDecimal r5 = r3.multiply(new BigDecimal(1).add((performanceV1.subtract(quota)).divide(performanceV1, 2, BigDecimal.ROUND_HALF_DOWN)));
        if ((performanceV1.compareTo(quota) == 1 || performanceV1.compareTo(quota) == 0)
                && performanceV1.compareTo(performanceV2) == 1) {
            BigDecimal dft = quota.multiply(r4).add((performanceV1.subtract(quota)).multiply(r5));
            if (performanceV2.compareTo(quota) == 1) {
                messageInfo.setData(dft.add((performanceV1.subtract(performanceV2)).multiply(r6)).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue());
                messageInfo.setContent("success");
                return messageInfo;
            }
            messageInfo.setData(dft.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue());
            messageInfo.setContent("success");
            return messageInfo;
        }
        messageInfo.setData(Double.parseDouble("0"));
        messageInfo.setContent("fail");
        return messageInfo;
    }
}
