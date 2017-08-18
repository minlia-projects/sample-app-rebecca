//package com.minlia.apps.sample.rebecca.interceptor;
//
//import org.springframework.http.HttpRequest;
//import org.springframework.http.client.ClientHttpRequestExecution;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.http.client.ClientHttpResponse;
//
//import java.io.IOException;
//
///**
// * Created by will on 8/18/17.
// */
//public class AccessTokenInterceptor implements ClientHttpRequestInterceptor {
//    @Override
//    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
//        //请求地址
//        String checkTokenUrl = request.getURI().getPath();
//        //token有效时间
//        int ttTime = (int) (System.currentTimeMillis() / 1000 + 1800);
//        //请求方法名 POST、GET等
//        String methodName = request.getMethod().name();
//        //请求内容
//        String requestBody = new String(body);
//        //生成令牌 此处调用一个自己写的方法.
//        //根据APPID, ACCESS_CODE生成一个API访问令牌
//        String token = "xxxxxxxx";
//        //将令牌放入请求header中
//        request.getHeaders().add("X-Auth-Token", token);
//
//        return execution.execute(request, body);
//    }
//}