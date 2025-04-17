//package com.main.Config;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.request.AsyncWebRequestInterceptor;
//
//@Configuration
//public class FeignConfig {
//
//    @Value("${student.api.key}")
//    private String studentApiKey;
//
//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return requestTemplate -> {
//            // Add the API Key to every request made by Feign client
//            requestTemplate.header("API-Key", studentApiKey);
//        };
//    }
//}
