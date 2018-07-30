package com.niule.market.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.niule.market.dao.mapper.AdvertMapper;
import com.niule.market.dao.mapper.AuthNoMapper;
import com.niule.market.dao.mapper.ChannelMapper;
import com.niule.market.dao.mapper.WorkAuthNoMapper;
import com.niule.market.dao.model.Advert;
import com.niule.market.dao.model.AuthNo;
import com.niule.market.dao.model.WorkAuthNo;
import com.niule.market.model.AdvertMakeInfo;
import com.niule.market.model.Share;
import com.niule.market.util.BizRunTimeException;
import com.niule.market.util.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Date;
import java.util.Hashtable;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 07 - 18 - 14:11
 */
@Slf4j
@Service
public class AdvertService {

    @Autowired
    private AdvertMapper advertMapper;
    @Autowired
    private AuthNoMapper authNoMapper;
    @Autowired
    private ChannelMapper channelMapper;
    @Autowired
    private WorkAuthNoMapper workAuthNoMapper;

//    public MessageV1 makeAdvert(AdvertMakeInfo advertMakeInfo) {
//        MessageV1 messageV1 = new MessageV1();
//        if (Objects.isNull(advertMakeInfo)) {
//            log.info("请输入生成所需要的信息!");
//            messageV1.setResult("请输入生成所需要的信息!");
//            return messageV1;
//        }
//        //判断类型 (1:二维码链接 2:url链接)
//        if (1 == advertMakeInfo.getType()) {
//            if (StringUtils.isEmpty(advertMakeInfo.getEwmUrl())) {
//                log.info("二维码路径不能为空!");
//                messageV1.setResult("二维码路径不能为空!");
//                return messageV1;
//            }
//            try {
//                QRCodeUtil.encode(advertMakeInfo.getEwmUrl(), "", advertMakeInfo.getEwmUrl(), true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        Advert advert = new Advert();
//        advert.setTitle(advertMakeInfo.getTitle());
//        advert.setChannelId(advertMakeInfo.getChannel());
//        advert.setContent(advertMakeInfo.getContent());
//        advert.setEwmUrl(advertMakeInfo.getEwmUrl() == null ? null : advertMakeInfo.getEwmUrl());
//        advert.setUrl(advertMakeInfo.getUrl() == null ? null : advertMakeInfo.getUrl());
//        advert.setType(advertMakeInfo.getType());
//        advert.setCreateTime(new Date());
//        int i = advertMapper.insert(advert);
//        if (1 != i) {
//            log.info("数据保存异常!");
//            throw new BizRunTimeException("数据保存异常!");
//        }
//        messageV1.setResult("success");
//        return messageV1;
//    }

    public MessageInfo<AdvertMakeInfo> makeAdvertV1(String qq, String workNo) throws Exception {
        MessageInfo<AdvertMakeInfo> messageInfo = new MessageInfo<>();
        if (StringUtils.isEmpty(qq)) {
            messageInfo.setResult("qq号不能为空");
            return messageInfo;
        }
        if (StringUtils.isEmpty(workNo)) {
            messageInfo.setResult("工号不能为空");
            return messageInfo;
        }
        WorkAuthNo workAuthNo = new WorkAuthNo();
        workAuthNo.setWorkNo(workNo);
        workAuthNo.setStatus(1);
        WorkAuthNo workAuthNoInfo = workAuthNoMapper.selectOne(workAuthNo);
        if (Objects.isNull(workAuthNoInfo)) {
            log.info("该工号目前还没有授权！");
            messageInfo.setResult("该工号目前还没有授权!");
            return messageInfo;
        }
        AdvertMakeInfo advertMakeInfo = new AdvertMakeInfo();
//        Advert advert = advertMapper.selectByPrimaryKey(1);
        Share inviteShareInfo = this.getInviteShareInfo(qq, Integer.parseInt(workNo));
        advertMakeInfo.setIcon(inviteShareInfo.getIcon());
        advertMakeInfo.setContent(inviteShareInfo.getContent());
        advertMakeInfo.setEwmUrl(inviteShareInfo.getQRcodeUrl());
        advertMakeInfo.setTitle(inviteShareInfo.getTitle());
        advertMakeInfo.setUrl(inviteShareInfo.getUrl());

        AuthNo authNo = new AuthNo();
        authNo.setAdvertId(1);
        authNo.setQq(qq);
        authNo.setWorkNo(workNo);
        authNo.setCreateTime(new Date());
        int i = authNoMapper.insertSelective(authNo);
        if (1 != i) {
            log.info("信息存储异常!");
            throw new BizRunTimeException("信息存储异常!");
        }
        messageInfo.setData(advertMakeInfo);
        messageInfo.setResult("success");
        return messageInfo;
    }

    public String getChannel(Integer channelId) {
        return channelMapper.selectByPrimaryKey(channelId).getValue();
    }

    public Share getInviteShareInfo(String qqNumber, Integer serviceId) throws Exception {
        //获取分享内容 + 链接拼接 + 二维码图片地址
        Advert advert = advertMapper.selectByPrimaryKey(1);
        Share share = new Share();
        share.setTitle(advert.getTitle());
        share.setContent(advert.getContent());
        share.setIcon(advert.getIcon());
        share.setUrl("http://api.yunjg.net/login.html?qqNumber=" + qqNumber + "&serviceId=" + serviceId);

        int width = 295;
        int height = 286;
        String format = "png";
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(share.getUrl(), BarcodeFormat.QR_CODE, width, height, hints);
//            Path file = new java.io.File("/home/www/images/QRCode_" + qqNumber + ".png").toPath();
            Path file = new java.io.File("/home/www/images/QRCode_" + qqNumber + ".png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        InputStream imagein = new FileInputStream("/home/www/images/dt.png");
        InputStream imagein2 = new FileInputStream("/home/www/images/QRCode_" + qqNumber + ".png");

        BufferedImage image = ImageIO.read(imagein);
        BufferedImage image2 = ImageIO.read(imagein2);
        Graphics g = image.getGraphics();
        g.drawImage(image2, 228, 677, 295, 286, null);

//        OutputStream outImage = new FileOutputStream("/home/www/images/QRCode/QRCode_" + qqNumber + ".jpg");
        String dstName = "/home/www/images/QRCode/QRCode_" + qqNumber + ".jpg";
        String formatName = dstName.substring(dstName.lastIndexOf(".") + 1);
        ImageIO.write(image, /*"GIF"*/ formatName /* format desired */, new File(dstName) /* target */);

//        Runtime.getRuntime().exec("chmod 644 -R " + "/home/www/images/QRCode/QRCode_"+qqNumber+".jpg");

//        JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(outImage);
//        enc.encode(image);
        imagein.close();
        imagein2.close();
//        outImage.close();
//        share.setQRcodeUrl("http://192.168.105.75:8088/images/QRCode/QRCode_" + qqNumber + ".jpg");
        share.setQRcodeUrl("http://image.yunjg.net/images/QRCode/QRCode_" + qqNumber + ".jpg");
        return share;
    }

}
