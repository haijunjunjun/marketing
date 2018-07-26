package com.niule.market.service;

import com.niule.market.dao.mapper.ActionMapper;
import com.niule.market.dao.mapper.AdvRecordMapper;
import com.niule.market.dao.model.Action;
import com.niule.market.dao.model.AdvRecord;
import com.niule.market.util.BizRunTimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 07 - 18 - 15:39
 */
@Slf4j
@Service
public class RecordService {

    @Autowired
    private AdvRecordMapper advRecordMapper;
    @Autowired
    private ActionMapper actionMapper;

    //获取用户的详细信息 ip地址、来源信息、访问url
    private Map<String, String> getDetailInfio(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        System.out.println("x-forwarded-for ip: " + ip);
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.indexOf(",") != -1) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            System.out.println("Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            System.out.println("WL-Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            System.out.println("HTTP_CLIENT_IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            System.out.println("HTTP_X_FORWARDED_FOR ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            System.out.println("X-Real-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            System.out.println("getRemoteAddr ip: " + ip);
        }

        String terminal = request.getHeader("User-Agent");
        if (terminal.contains("Windows NT")) {
            terminal = "PC端";
        } else {
            terminal = "移动端";
        }
        Map<String, String> map = new HashMap<>();
        map.put("ip", ip);
        map.put("resource", terminal);
        map.put("viewUrl", request.getRequestURL().toString());
        System.out.println("访客IP：" + ip);
        System.out.println("用户访问来源：" + terminal);
        System.out.println("访问URL：" + request.getRequestURL().toString());
        return map;
    }

    public void jump(HttpServletRequest request, Integer advertId, Integer actionCode) {
        if (StringUtils.isEmpty(advertId.toString()) || advertId <= 0) {
            log.info("路径参数信息异常！");
            throw new BizRunTimeException("路径参数信息异常！");
        }
        if (StringUtils.isEmpty(actionCode) || actionCode <= 0) {
            log.info("行为代码参数信息异常！");
            throw new BizRunTimeException("行为代码参数异常！");
        }
        Action action = this.getAction(actionCode);
        AdvRecord advRecord = new AdvRecord();
        advRecord.setAdvertId(advertId);
        advRecord.setAction(action.getAction());
        Map<String, String> detailInfio = this.getDetailInfio(request);
        advRecord.setIp(detailInfio.get("ip"));
        advRecord.setResource(detailInfio.get("resource"));
        advRecord.setViewUrl(detailInfio.get("viewUrl"));
        advRecord.setCreateTime(new Date());
        int i = advRecordMapper.insert(advRecord);
        if (1 != i) {
            log.info("信息存储异常!");
            throw new BizRunTimeException("信息存储异常!");
        }
        Action actionV1 = new Action();
        actionV1.setId(actionCode);
        actionV1.setHappenCount(action.getHappenCount() + 1);
        int updateInfo = actionMapper.updateByPrimaryKeySelective(actionV1);
        if (Objects.isNull(updateInfo)) {
            log.info("信息更新异常!");
            throw new BizRunTimeException("信息更新异常!");
        }
        return;
    }

    private Action getAction(Integer code) {
        return actionMapper.selectByPrimaryKey(code);
    }
}
