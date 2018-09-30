package com.example.demo.service;

import com.example.demo.config.base64.MultipartFileV1;
import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.mapper.DefaultResourceMapper;
import com.example.demo.dal.mapper.UserInfoMapper;
import com.example.demo.dal.mapper.UserPerformanceMapper;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.model.UserInfo;
import com.example.demo.dal.model.UserPerformance;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.MessageInfoV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class FileUploadService {

    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private UserPerformanceMapper userPerformanceMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private DefaultResourceMapper defaultResourceMapper;

    public MessageInfoV1 uploadFileV1(Integer custId, String base64,String compactNo) {
        MessageInfoV1 messageInfoV1 = new MessageInfoV1();
        MultipartFile multipartFile = MultipartFileV1.base64ToMultipart(base64);
//        String uploadPath = "D://path/compact/";
        //http://106.15.37.191/
        String uploadPath = "/home/www/upload/images/compact/";
        if (StringUtils.isEmpty(custId.toString()) || custId <= 0) {
            log.info("custId 参数传递异常!");
            throw new BizRuntimeException("userId 参数传递异常!");
        }
        if (multipartFile.isEmpty()) {
            messageInfoV1.setContent("文件为空!");
            return messageInfoV1;
        }
        if (StringUtils.isEmpty(uploadPath)) {
            log.info("上传路径为空！");
            throw new BizRuntimeException("上传路径为空!");
        }
        String originName = multipartFile.getOriginalFilename();
        String suffixName = originName.substring(originName.lastIndexOf("."));
        String filename = UUID.randomUUID().toString() + suffixName;
        String realPath = uploadPath + custId + "/" + filename;
        String url = "http://106.15.37.191/images/compact/" + custId + "/" + filename;
        File dest = new File(realPath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest);
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setId(custId);
            customerInfo.setCompactImg(url);
            customerInfo.setCompactTime(new Date());
            customerInfo.setCompactNo(compactNo);
            customerInfo.setIsCompact(1);
            customerInfo.setIsCompactCheck(2);
            int i = customerInfoMapper.updateByPrimaryKeySelective(customerInfo);
            if (1 != i) {
                log.info("数据库更新失败!");
                throw new BizRuntimeException("数据库更新失败!");
            }

            log.info("上传成功!");
            messageInfoV1.setContent("上传成功!");
            return messageInfoV1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageInfoV1.setContent("上传失败!");
        return messageInfoV1;
    }

    public MessageInfoV1 uploadFileV2(Integer userId, MultipartFile multipartFile) {
        //http://106.15.37.191/images/awater/_1/user_1.jpeg
        MessageInfoV1 messageInfoV1 = new MessageInfoV1();
//        String uploadPath = "D://path/awater/";
        String uploadPath = "/home/www/upload/images/awater/";
        if (StringUtils.isEmpty(userId.toString()) || userId <= 0) {
            log.info("userId 参数传递异常!");
            throw new BizRuntimeException("userId 参数传递异常!");
        }
        if (multipartFile.isEmpty()) {
            messageInfoV1.setContent("文件为空!");
            return messageInfoV1;
        }
        if (StringUtils.isEmpty(uploadPath)) {
            log.info("上传路径为空！");
            throw new BizRuntimeException("上传路径为空!");
        }
        String originName = multipartFile.getOriginalFilename();
        String suffixName = originName.substring(originName.lastIndexOf("."));
        String filename = UUID.randomUUID().toString() + suffixName;
        String realPath = uploadPath + userId + "/" + filename;
        String url = "http://106.15.37.191/images/awater/" + userId + "/" + filename;
        File dest = new File(realPath);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest);
            UserInfo userInfo = new UserInfo();
            userInfo.setId(userId);
            userInfo.setImageUrl(url);
            int i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
            if (1 != i) {
                log.info("数据库更新失败!");
                throw new BizRuntimeException("数据库更新失败!");
            }
            messageInfoV1.setContent("上传成功!");
            return messageInfoV1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        messageInfoV1.setContent("上传失败!");
        return messageInfoV1;
    }

    public MessageInfoV1 getCustCompact(Integer custId) {
        MessageInfoV1 messageInfoV1 = new MessageInfoV1();
        if (Objects.isNull(custId)) {
            log.info("参数信息异常!");
            throw new BizRuntimeException("参数信息异常！");
        }
        CustomerInfo customerInfo = customerInfoMapper.selectByPrimaryKey(custId);
        if (Objects.isNull(customerInfo)) {
            log.info("数据库信息异常!");
            throw new BizRuntimeException("数据库信息异常！");
        }
        if (customerInfo.getCompactImg() == null || customerInfo.getCompactImg().length() == 0) {
            messageInfoV1.setContent("null");
        } else {
            messageInfoV1.setContent(customerInfo.getCompactImg());
        }
        return messageInfoV1;
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
            customerInfo.setCheckTime(new Date());
            customerInfo.setModifyTime(new Date());
            customerInfo.setLastModifyTime(new Date());

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
        } else if (0 == isCompactCheck) {
            customerInfo.setIsCompactCheck(isCompactCheck);
            customerInfo.setCheckTime(new Date());
            customerInfo.setModifyTime(new Date());
            customerInfo.setLastModifyTime(new Date());
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
