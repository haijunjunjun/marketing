package com.example.demo.service;

import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.mapper.UserCommissionsMapper;
import com.example.demo.dal.mapper.UserPerformanceMapper;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.model.UserPerformance;
import com.example.demo.util.BizRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class FileUploadService {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private UserPerformanceMapper userPerformanceMapper;
    @Autowired
    private UserCommissionsMapper userCommissionsMapper;

    public String uploadFile(Integer custId, MultipartFile multipartFile, String uploadPath) {
        if (StringUtils.isEmpty(custId.toString()) || custId <= 0) {
            log.info("custId 参数传递异常!");
            throw new BizRuntimeException("userId 参数传递异常!");
        }
        if (multipartFile.isEmpty()) {
            return "文件为空!";
        }
        if (StringUtils.isEmpty(uploadPath)) {
            log.info("上传路径为空！");
            throw new BizRuntimeException("上传路径为空!");
        }
        String filename = multipartFile.getOriginalFilename();
        log.info("上传的文件名为:" + filename);
        String suffixName = filename.substring(filename.lastIndexOf("."));
        log.info("上传文件的后缀名为:" + suffixName);
        String realPath = uploadPath + custId + "/" + filename;
        File dest = new File(realPath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest);
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setId(custId);
            customerInfo.setCompactImg(realPath);
            customerInfo.setIsCompact(1);
            int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
            if (1 != i) {
                log.info("数据库更新失败!");
                throw new BizRuntimeException("数据库更新失败!");
            }
            return "上传成功!";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败!";
    }

    public String compactCheck(Integer custId, Integer isCompactCheck, String checkRefuseReason) {
        if (StringUtils.isEmpty(custId.toString()) || custId <= 0 || StringUtils.isEmpty(isCompactCheck) || isCompactCheck < 0) {
            log.info("参数信息传递异常!");
            throw new BizRuntimeException("参数信息传递异常!");
        }
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(custId);
        if (1 == isCompactCheck) {
            customerInfo.setIsCompactCheck(isCompactCheck);
            customerInfo.setStatus(2);

            //对销售人员的业绩 添加记录
            UserPerformance userPerformance = new UserPerformance();
            CustomerInfo customerInfoV1 = customerInfoMapper.selectByPrimaryKey(custId);
            if (Objects.isNull(customerInfoV1)) {
                log.info("数据查询异常!");
                throw new BizRuntimeException("数据查询异常!");
            }
            userPerformance.setUserId(customerInfoV1.getUserId());
            userPerformance.setCustId(custId);
            userPerformance.setPerformance(customerInfoV1.getPrice());
            userPerformance.setCreateTime(new Date());
            int performanceResult = userPerformanceMapper.insert(userPerformance);
            if (1 != performanceResult) {
                log.info("数据库更新异常!");
                throw new BizRuntimeException("数据库更新异常!");
            }
        } else {
            customerInfo.setIsCompactCheck(isCompactCheck);
            customerInfo.setCheckRefuseReason(checkRefuseReason);
        }
        int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
        if (1 != i) {
            log.info("数据库更新失败!");
            throw new BizRuntimeException("数据库更新失败!");
        }
        return "审核成功!";
    }

    public List<CustomerInfo> getCompactCheckList() {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setIsCompact(1);
        customerInfo.setIsCompactCheck(0);
        List<CustomerInfo> dataList = customerInfoMapper.select(customerInfo);
        return dataList;
    }
}
