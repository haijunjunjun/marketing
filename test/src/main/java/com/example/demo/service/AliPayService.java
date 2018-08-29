//package com.example.cache.rediscache.service;
//
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.internal.util.AlipaySignature;
//import com.alipay.api.request.AlipayTradePayRequest;
//import com.alipay.api.response.AlipayTradePrecreateResponse;
//import com.example.cache.rediscache.apliPayTrade.config.Configs;
//import com.example.cache.rediscache.apliPayTrade.model.ExtendParams;
//import com.example.cache.rediscache.apliPayTrade.model.builder.AlipayTradePrecreateRequestBuilder;
//import com.example.cache.rediscache.apliPayTrade.model.result.AlipayF2FPrecreateResult;
//import com.example.cache.rediscache.apliPayTrade.service.AlipayTradeService;
//import com.example.cache.rediscache.apliPayTrade.utils.ZxingUtils;
//import com.example.cache.rediscache.config.AliPayConfig;
//import com.example.cache.rediscache.util.MessageInfo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import sun.misc.BASE64Encoder;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.util.Enumeration;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author haijun
// * @create 2018 - 08 - 22 - 18:15
// */
//@Slf4j
//@Service
//public class AliPayService {
//
//    @Autowired
//    private AliPayConfig aliPayConfig;
//    @Autowired
//    private AlipayTradeService tradeService;
//
//    public Map<String, String> precreate() throws Exception {
//        MessageInfo messageInfo = new MessageInfo();
//
//        Map<String, String> map = new HashMap<String, String>();
//        String amount = "0.01";
//        // (必填) 商户网站订单系统中唯一订单号，64个字符以内，只能包含字母、数字、下划线，
//        // 需保证商户系统端不能重复，建议通过数据库sequence生成，
//        String outTradeNo = "48" + System.currentTimeMillis() + (long) (Math.random() * 10000000L);
//
//        // (必填) 订单标题，粗略描述用户的支付目的。如“xxx品牌xxx门店当面付扫码消费”
//        String subject = "向云加工支付";
//
//        // (必填) 订单总金额，单位为元，不能超过1亿元
//        // 如果同时传入了【打折金额】,【不可打折金额】,【订单总金额】三者,则必须满足如下条件:【订单总金额】=【打折金额】+【不可打折金额】
//        String totalAmount = amount;
//
//        // (可选) 订单不可打折金额，可以配合商家平台配置折扣活动，如果酒水不参与打折，则将对应金额填写至此字段
//        // 如果该值未传入,但传入了【订单总金额】,【打折金额】,则该值默认为【订单总金额】-【打折金额】
//        String undiscountableAmount = "0";
//
//        // 卖家支付宝账号ID，用于支持一个签约账号下支持打款到不同的收款账号，(打款到sellerId对应的支付宝账号)
//        // 如果该字段为空，则默认为与支付宝签约的商户的PID，也就是appid对应的PID
////        String sellerId = "2088231281029929";
//
//        // 订单描述，可以对交易或商品进行一个详细地描述，比如填写"购买商品2件共15.00元"
//        String body = "id为48的客户 支付0.01元";
//
////        // 商户操作员编号，添加此参数可以为商户操作员做销售统计
////        String operatorId = "001";
////
////        // (必填) 商户门店编号，通过门店号和商家后台可以配置精准到门店的折扣信息，详询支付宝技术支持
////        String storeId = "2088102172329883";
//
//        // 业务扩展参数，目前可添加由支付宝分配的系统商编号(通过setSysServiceProviderId方法)，详情请咨询支付宝技术支持
//        ExtendParams extendParams = new ExtendParams();
//        extendParams.setSysServiceProviderId("2088231281029929");
//
//        // 支付超时，定义为120分钟
//        String timeoutExpress = "120m";
//
////        // 商品明细列表，需填写购买商品详细信息，
////        List<GoodsDetail> goodsDetailList = new ArrayList<GoodsDetail>();
////        // 创建一个商品信息，参数含义分别为商品id（使用国标）、名称、单价（单位为分）、数量，如果需要添加商品类别，详见GoodsDetail
////        GoodsDetail goods1 = GoodsDetail.newInstance("goods_id001", "xxx小面包", 1000, 1);
////        // 创建好一个商品后添加至商品明细列表
////        goodsDetailList.add(goods1);
////
////        // 继续创建并添加第一条商品信息，用户购买的产品为“黑人牙刷”，单价为5.00元，购买了两件
////        GoodsDetail goods2 = GoodsDetail.newInstance("goods_id002", "xxx牙刷", 500, 2);
////        goodsDetailList.add(goods2);
//
//        // 创建扫码支付请求builder，设置请求参数
//        AlipayTradePrecreateRequestBuilder builder = new AlipayTradePrecreateRequestBuilder()
//                .setSubject(subject)
//                .setTotalAmount(totalAmount)
//                .setOutTradeNo(outTradeNo)
//                .setUndiscountableAmount(undiscountableAmount)
////                .setSellerId(sellerId)
//                .setBody(body)
////                .setOperatorId(operatorId)
////                .setStoreId(storeId)
//                .setExtendParams(extendParams)
//                .setTimeoutExpress(timeoutExpress)
//                .setNotifyUrl("http://localhost:8080/baobiao/pay/notify");//支付宝服务器主动通知商户服务器里指定的页面http路径,根据需要设置，这里我们设置的是我们自己写的一个接口，等下会有介绍
////                .setGoodsDetailList(goodsDetailList);
//
//        AlipayF2FPrecreateResult result = tradeService.tradePrecreate(builder);
//        String png_base64;
//        switch (result.getTradeStatus()) {
//            case SUCCESS:
//                log.info("支付宝预下单成功: )");
//                System.out.println("支付宝预下单成功: )");
//
//                AlipayTradePrecreateResponse response = result.getResponse();
//
////                // 需要修改为运行机器上的路径
////                String filePath = String.format("D://aliPay", response.getOutTradeNo());
////                log.info("filePath:" + filePath);
////                ZxingUtils.getQRCodeImge(response.getQrCode(), 256, filePath);
//                BufferedImage image = ZxingUtils.getQRCodeImge(response.getQrCode());
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
//                ImageIO.write(image, "png", baos);//写入流中
//                byte[] bytes = baos.toByteArray();//转换成字节
//                BASE64Encoder encoder = new BASE64Encoder();
//                png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
//                png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
//
//                //生成订单，插入数据库
//                System.out.println("body:" + response.getBody());
//
////                map.put("status", "true");
////                map.put("qrcode", response.getQrCode()); //返回给客户端二维码
////                map.put("outtradeno", outTradeNo);
//                map.put("base64", png_base64);
//
//                return map;
//
//            case FAILED:
//                log.error("支付宝预下单失败!!!");
//                System.out.println("支付宝预下单失败!!!");
//                System.out.println(result.getResponse().getBody());
//                break;
//
//            case UNKNOWN:
//                log.error("系统异常，预下单状态未知!!!");
//                System.out.println("系统异常，预下单状态未知!!!");
//                break;
//
//            default:
//                log.error("不支持的交易状态，交易返回异常!!!");
//                System.out.println("不支持的交易状态，交易返回异常!!!");
//                break;
//        }
//        map.put("status", "false");
//        map.put("msg", "系统出现异常，请稍后再试！");
//        return map;
//    }
//
//    public String notifyAlipay(HttpServletRequest request, HttpServletResponse response) {
//        log.info("收到支付宝异步通知！");
//        Map<String, String> params = new HashMap<String, String>();
//
//        //取出所有参数是为了验证签名
//        Enumeration<String> parameterNames = request.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String parameterName = parameterNames.nextElement();
//            params.put(parameterName, request.getParameter(parameterName));
//        }
//        boolean signVerified;
//        try {
//            signVerified = AlipaySignature.rsaCheckV1(params, Configs.getAlipayPublicKey(), "UTF-8");
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//            return "failed";
//        }
//        if (signVerified) {
//            String outtradeno = params.get("out_trade_no");
//            log.info(outtradeno + "号订单回调通知。");
////            System.out.println("验证签名成功！");
//            log.info("验证签名成功！");
//
//            //若参数中的appid和填入的appid不相同，则为异常通知
//            if (!Configs.getAppid().equals(params.get("app_id"))) {
//                log.warn("与付款时的appid不同，此为异常通知，应忽略！");
//                return "failed";
//            }
//
////            //在数据库中查找订单号对应的订单，并将其金额与数据库中的金额对比，若对不上，也为异常通知
////            BaobiaoOrder order = baobiaoOrderService.findOrderByOuttradeno(outtradeno);
////            if (order == null) {
////                log.warn(outtradeno + "查无此订单！");
////                return "failed";
////            }
////            if (order.getAmount() != Double.parseDouble(params.get("total_amount"))) {
////                log.warn("与付款时的金额不同，此为异常通知，应忽略！");
////                return "failed";
////            }
////
////            if (order.getStatus() == BaobiaoOrder.TRADE_SUCCESS) return "success"; //如果订单已经支付成功了，就直接忽略这次通知
////
////            String status = params.get("trade_status");
////            if (status.equals("WAIT_BUYER_PAY")) { //如果状态是正在等待用户付款
////                if (order.getStatus() != BaobiaoOrder.WAIT_BUYER_PAY) baobiaoOrderService.modifyTradeStatus(BaobiaoOrder.WAIT_BUYER_PAY, outtradeno);
////            } else if (status.equals("TRADE_CLOSED")) { //如果状态是未付款交易超时关闭，或支付完成后全额退款
////                if (order.getStatus() != BaobiaoOrder.TRADE_CLOSED) baobiaoOrderService.modifyTradeStatus(BaobiaoOrder.TRADE_CLOSED, outtradeno);
////            } else if (status.equals("TRADE_SUCCESS") || status.equals("TRADE_FINISHED")) { //如果状态是已经支付成功
////                if (order.getStatus() != BaobiaoOrder.TRADE_SUCCESS) baobiaoOrderService.modifyTradeStatus(BaobiaoOrder.TRADE_SUCCESS, outtradeno);
////            } else {
////                baobiaoOrderService.modifyTradeStatus(BaobiaoOrder.UNKNOWN_STATE, outtradeno);
////            }
////            log.info(outtradeno + "订单的状态已经修改为" + status);
//        } else { //如果验证签名没有通过
//            return "failed";
//        }
//        return "success";
//    }
//
//    public String precreateV1(AlipayTradePayRequest alipayTradePayRequest) {
//        return null;
//    }
//}
//
//
