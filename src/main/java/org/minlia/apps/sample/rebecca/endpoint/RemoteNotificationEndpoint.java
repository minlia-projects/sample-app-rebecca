package org.minlia.apps.sample.rebecca.endpoint;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.LowerCaseStrategy;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by will on 9/14/17.
 */
@RestController
@RequestMapping(value = "/api/open/callback/unified")//http://v8.s1.natapp.cc/api/open/callback/unified/payment
public class RemoteNotificationEndpoint {


  //先分发是支付宝还是微信的
  //将这2个都转换成统一的业务相关的BODY
  //支付完成通知BODY

  @RequestMapping(value = "payment")
  public void payment(HttpServletRequest request){
//    进行分发
    dispatch(request);

    String xmlString = null;
    try {
      BufferedReader reader = null;
      reader = request.getReader();
      String line = "";

      StringBuffer inputString = new StringBuffer();
      while ((line = reader.readLine()) != null) {
        inputString.append(line);
      }
      xmlString = inputString.toString();
      request.getReader().close();
      System.out.println("----接收到的数据如下：---" + xmlString);
    }catch (Exception e){
      e.printStackTrace();
    }

    if(org.apache.commons.lang3.StringUtils.isEmpty(xmlString)){
      System.out.println("WECHAT "+xmlString);
      //<xml><appid><![CDATA[wxc2be3132a353e6d2]]></appid><bank_type><![CDATA[CFT]]></bank_type><cash_fee><![CDATA[1]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[N]]></is_subscribe><mch_id><![CDATA[1488903742]]></mch_id><nonce_str><![CDATA[fBzjXWrfZLtyx4AWTpMdpwJOsGyyyseH]]></nonce_str><openid><![CDATA[owaY71pzMDLQcm-IHOIf-TmAsk2Q]]></openid><out_trade_no><![CDATA[2017815134232152]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[6CF1FFFBF1F3D3905EEEAB3B8273E630]]></sign><time_end><![CDATA[20170915134240]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[APP]]></trade_type><transaction_id><![CDATA[4004642001201709152213366749]]></transaction_id></xml>
    }else{
      //进行支付宝判断
    }

		Map<String, Object> map = new HashMap<String, Object>();
		String result_code = "";
		String out_trade_no = "";
//		map = XMLParser.getMapFromXML(xmlString);



    System.out.println(request);
    System.out.println("跳转过来了。");



    Map<String, String> underScoreKeyMap = RequestUtils.getStringParams(request);
    Map<String, String> camelCaseKeyMap = RequestUtils.convertKeyToCamelCase(underScoreKeyMap);
    // 首先验证调用是否来自支付宝


    //{gmt_create=2017-09-15 13:45:39, charset=UTF-8, seller_email=moffvape@gmail.com, subject=支付主题, sign=Qa+Jsgh1REHYYywQFnq3PxruLnpR5FJ67dTL3JrzuvLlsug7e5IRRUieFfABnDFHrh3C/QDeWc1vC1ihfnGsd+3ZSSTA2vlcGf+Piv9R/9ovlTOR6/aBbZbHxy6XjC6IVQB0o6Q/j9Cp4MYzrcpLbbJGxVN5NKJlqHpfSWtiR0dMEfVh0gJsfsGk7dL+92rM8MP6/kqY56TGZPtGBiPedd4cCiOcYf/gv3kAPuWoTZSwmJ91F4KQ9YT3RwHRJeErDBhY720j/WoEmYQgSVxyBjH7uXNI4YUdlCcVRZOkTlaXnXFSEXEnqjuCIJL2lvmZhWP7MRsk6GTZesg1pM8mmA==, body=备注内容, buyer_id=2088002650456370, invoice_amount=0.01, notify_id=d0ee51e133fcf51fd8681589b16ae12iuu, fund_bill_list=[{"amount":"0.01","fundChannel":"ALIPAYACCOUNT"}], notify_type=trade_status_sync, trade_status=TRADE_SUCCESS, receipt_amount=0.01, app_id=2017082408355971, buyer_pay_amount=0.01, sign_type=RSA2, seller_id=2088721842507129, gmt_payment=2017-09-15 13:45:39, notify_time=2017-09-15 13:45:40, version=1.0, out_trade_no=AO412048142287, total_amount=0.01, trade_no=2017091521001004370223857095, auth_app_id=2017082408355971, buyer_logon_id=mmi***@live.com, point_amount=0.00}
//    {charset=UTF-8, subject=支付主题, sign=Qa+Jsgh1REHYYywQFnq3PxruLnpR5FJ67dTL3JrzuvLlsug7e5IRRUieFfABnDFHrh3C/QDeWc1vC1ihfnGsd+3ZSSTA2vlcGf+Piv9R/9ovlTOR6/aBbZbHxy6XjC6IVQB0o6Q/j9Cp4MYzrcpLbbJGxVN5NKJlqHpfSWtiR0dMEfVh0gJsfsGk7dL+92rM8MP6/kqY56TGZPtGBiPedd4cCiOcYf/gv3kAPuWoTZSwmJ91F4KQ9YT3RwHRJeErDBhY720j/WoEmYQgSVxyBjH7uXNI4YUdlCcVRZOkTlaXnXFSEXEnqjuCIJL2lvmZhWP7MRsk6GTZesg1pM8mmA==, invoiceAmount=0.01, body=备注内容, buyerId=2088002650456370, buyerLogonId=mmi***@live.com, receiptAmount=0.01, sellerId=2088721842507129, gmtPayment=2017-09-15 13:45:39, appId=2017082408355971, outTradeNo=AO412048142287, signType=RSA2, fundBillList=[{"amount":"0.01","fundChannel":"ALIPAYACCOUNT"}], pointAmount=0.00, tradeNo=2017091521001004370223857095, notifyTime=2017-09-15 13:45:40, gmtCreate=2017-09-15 13:45:39, sellerEmail=moffvape@gmail.com, version=1.0, totalAmount=0.01, notifyType=trade_status_sync, tradeStatus=TRADE_SUCCESS, buyerPayAmount=0.01, notifyId=d0ee51e133fcf51fd8681589b16ae12iuu, authAppId=2017082408355971}
//    {"gmt_create":"2017-09-15 13:45:39","charset":"UTF-8","seller_email":"moffvape@gmail.com","subject":"支付主题","sign":"Qa+Jsgh1REHYYywQFnq3PxruLnpR5FJ67dTL3JrzuvLlsug7e5IRRUieFfABnDFHrh3C/QDeWc1vC1ihfnGsd+3ZSSTA2vlcGf+Piv9R/9ovlTOR6/aBbZbHxy6XjC6IVQB0o6Q/j9Cp4MYzrcpLbbJGxVN5NKJlqHpfSWtiR0dMEfVh0gJsfsGk7dL+92rM8MP6/kqY56TGZPtGBiPedd4cCiOcYf/gv3kAPuWoTZSwmJ91F4KQ9YT3RwHRJeErDBhY720j/WoEmYQgSVxyBjH7uXNI4YUdlCcVRZOkTlaXnXFSEXEnqjuCIJL2lvmZhWP7MRsk6GTZesg1pM8mmA==","body":"备注内容","buyer_id":"2088002650456370","invoice_amount":"0.01","notify_id":"d0ee51e133fcf51fd8681589b16ae12iuu","fund_bill_list":"[{\"amount\":\"0.01\",\"fundChannel\":\"ALIPAYACCOUNT\"}]","notify_type":"trade_status_sync","trade_status":"TRADE_SUCCESS","receipt_amount":"0.01","app_id":"2017082408355971","buyer_pay_amount":"0.01","sign_type":"RSA2","seller_id":"2088721842507129","gmt_payment":"2017-09-15 13:45:39","notify_time":"2017-09-15 13:45:40","version":"1.0","out_trade_no":"AO412048142287","total_amount":"0.01","trade_no":"2017091521001004370223857095","auth_app_id":"2017082408355971","buyer_logon_id":"mmi***@live.com","point_amount":"0.00"}

    System.out.println(underScoreKeyMap.toString());
    System.out.println(camelCaseKeyMap.toString());
    PrintWriter printWriter = null;
    String resultResponse = "success";
    if ("TRADE_SUCCESS".equals(request.getParameter("trade_status"))) {
      Enumeration<?> pNames = request.getParameterNames();
      Map<String, String> param = new HashMap<String, String>();
      try {
        while (pNames.hasMoreElements()) {
          String pName = (String) pNames.nextElement();
          param.put(pName, request.getParameter(pName));
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(new LowerCaseStrategy());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String paramJson=objectMapper.writeValueAsString(param);
        System.out.println(paramJson);

//        System.out.println("验证前商品总价和: " + param.get("totle_amount"));
//        System.out.println(param.toString());
//        boolean signVerified = AlipaySignature.rsaCheckV1(param, AlipayUtil.ALIPAY_PUBLIC_KEY,
//            AlipayConstants.CHARSET_UTF8); // 校验签名是否正确
//        if (signVerified) {
//          // TODO 验签成功后
//          String jsonStr = JSON.toJSONString(camelCaseKeyMap);
//          AlipayNotification notice = JSON.parseObject(jsonStr, AlipayNotification.class);
//          System.out.println("支付宝交易单号: " + notice.getTradeNo());
//          System.out.println("订单号: " + notice.getOutTradeNo());
//          System.out.println("订单描述: " + notice.getBody());
//          System.out.println("商品名称: " + notice.getSubject());
//          System.out.println("商品总价: " + notice.getTotalFee());
//          // 按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success，校验失败返回failure
//          logger.info("订单支付成功：" + JSON.toJSONString(param));
//          printWriter = response.getWriter();
//        } else {
//          resultResponse = "failure";
//          System.out.println("验签失败");
//          // TODO 验签失败则记录异常日志，并在response中返回failure.
//        }
      } catch (Exception e) {
        resultResponse = "failure";
        e.printStackTrace();
      }
    }
    if (printWriter != null) {
      printWriter.print(resultResponse);
    }
  }

  private void dispatch(HttpServletRequest request) {


  }

}
