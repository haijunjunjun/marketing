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
import org.springframework.dao.DuplicateKeyException;
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
        AuthNo authNo = new AuthNo();
        authNo.setAdvertId(1);
        authNo.setQq(qq);
        authNo.setWorkNo(workNo);
        authNo.setCreateTime(new Date());
        try {
            int i = authNoMapper.insertSelective(authNo);
            if (1 != i) {
                log.info("信息存储异常!");
                throw new BizRunTimeException("信息存储异常!");
            }
        } catch (DuplicateKeyException e) {
            messageInfo.setResult("该qq号已授权!");
            Share inviteShareInfo = this.getInviteShareInfo(qq, Integer.parseInt(workNo),authNo.getId());
            advertMakeInfo.setIcon(inviteShareInfo.getIcon());
            advertMakeInfo.setContent(inviteShareInfo.getContent());
            advertMakeInfo.setEwmUrl(inviteShareInfo.getQRcodeUrl());
            advertMakeInfo.setTitle(inviteShareInfo.getTitle());
            advertMakeInfo.setUrl(inviteShareInfo.getUrl());
            advertMakeInfo.setAuthNoId(authNo.getId());
            messageInfo.setData(advertMakeInfo);
            return messageInfo;
        }
        Share inviteShareInfo = this.getInviteShareInfo(qq, Integer.parseInt(workNo),authNo.getId());
        advertMakeInfo.setIcon(inviteShareInfo.getIcon());
        advertMakeInfo.setContent(inviteShareInfo.getContent());
        advertMakeInfo.setEwmUrl(inviteShareInfo.getQRcodeUrl());
        advertMakeInfo.setTitle(inviteShareInfo.getTitle());
        advertMakeInfo.setUrl(inviteShareInfo.getUrl());
        advertMakeInfo.setAuthNoId(authNo.getId());
        messageInfo.setData(advertMakeInfo);
        messageInfo.setResult("success");
        return messageInfo;
    }

    public String getChannel(Integer channelId) {
        return channelMapper.selectByPrimaryKey(channelId).getValue();
    }
    //线上
//    public Share getInviteShareInfo(String qqNumber, Integer serviceId, Integer authNoId) throws Exception {
//        //获取分享内容 + 链接拼接 + 二维码图片地址
//        Advert advert = advertMapper.selectByPrimaryKey(1);
//        Share share = new Share();
//        share.setTitle(advert.getTitle());
//        share.setContent(advert.getContent());
//        share.setIcon(advert.getIcon());
//        share.setUrl("http://api.yunjg.net/login.html?qqNumber=" + qqNumber + "&serviceId=" + serviceId + "&authNoId=" + authNoId + "&advertId=1");
//
//        int width = 295;
//        int height = 286;
//        String format = "png";
//        Hashtable hints = new Hashtable();
//        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
//        hints.put(EncodeHintType.MARGIN, 2);
//        try {
//            BitMatrix bitMatrix = new MultiFormatWriter().encode(share.getUrl(), BarcodeFormat.QR_CODE, width, height, hints);
////            Path file = new java.io.File("/home/www/images/QRCode_" + qqNumber + ".png").toPath();
//            Path file = new java.io.File("/home/www/images/QRCode_" + qqNumber + ".png").toPath();
//            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//
//        InputStream imagein = new FileInputStream("/home/www/images/dt.png");
//        InputStream imagein2 = new FileInputStream("/home/www/images/QRCode_" + qqNumber + ".png");
//
//        BufferedImage image = ImageIO.read(imagein);
//        BufferedImage image2 = ImageIO.read(imagein2);
//        Graphics g = image.getGraphics();
//        g.drawImage(image2, 228, 677, 295, 286, null);
//
//
//        String dstName = "/home/www/images/QRCode/QRCode_" + qqNumber + ".jpg";
//        String formatName = dstName.substring(dstName.lastIndexOf(".") + 1);
//        ImageIO.write(image, /*"GIF"*/ formatName /* format desired */, new File(dstName) /* target */);
//
////        OutputStream outImage = new FileOutputStream("/home/www/images/QRCode/QRCode_" + qqNumber + ".jpg");
////        JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(outImage);
////        enc.encode(image);
//
//        Runtime.getRuntime().exec("chmod 644 -R " + "/home/www/images/QRCode/QRCode_" + qqNumber + ".jpg");
//
//        imagein.close();
//        imagein2.close();
////        outImage.close();
//        share.setQRcodeUrl("http://image.yunjg.net/images/QRCode/QRCode_" + qqNumber + ".jpg");
//        return share;
//    }

    //本地
    public Share getInviteShareInfo(String qqNumber, Integer serviceId, Integer authNoId) throws Exception {
        //获取分享内容 + 链接拼接 + 二维码图片地址
        Advert advert = advertMapper.selectByPrimaryKey(1);
        Share share = new Share();
        share.setTitle(advert.getTitle());
        share.setContent(advert.getContent());
        share.setIcon(advert.getIcon());
        share.setUrl("http://api.yunjg.net/login.html?qqNumber=" + qqNumber + "&serviceId=" + serviceId + "&authNoId=" + authNoId + "&advertId=1");

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
            Path file = new java.io.File("D://image/QRCode_" + qqNumber + ".png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        InputStream imagein = new FileInputStream("D://dt.png");
        InputStream imagein2 = new FileInputStream("D://image/QRCode_" + qqNumber + ".png");

        BufferedImage image = ImageIO.read(imagein);
        BufferedImage image2 = ImageIO.read(imagein2);
        Graphics g = image.getGraphics();
        g.drawImage(image2, 228, 677, 295, 286, null);


        String dstName = "D://image/QRCode/QRCode_" + qqNumber + ".jpg";
        String formatName = dstName.substring(dstName.lastIndexOf(".") + 1);
        ImageIO.write(image, /*"GIF"*/ formatName /* format desired */, new File(dstName) /* target */);

//        OutputStream outImage = new FileOutputStream("/home/www/images/QRCode/QRCode_" + qqNumber + ".jpg");
//        JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(outImage);
//        enc.encode(image);

//        Runtime.getRuntime().exec("chmod 644 -R " + "/home/www/images/QRCode/QRCode_" + qqNumber + ".jpg");

        imagein.close();
        imagein2.close();
//        outImage.close();
        share.setQRcodeUrl("http://image.yunjg.net/images/QRCode/QRCode_" + qqNumber + ".jpg");
        return share;
    }

}
