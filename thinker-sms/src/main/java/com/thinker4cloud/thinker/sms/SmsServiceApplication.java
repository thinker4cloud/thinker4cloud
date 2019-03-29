package com.thinker4cloud.thinker.sms;

import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmsServiceApplication {


    @Value("${aliyun.sms.regionId}")
    public String regionId;

    @Value("${aliyun.sms.accessKeyId}")
    public String accessKeyId;


    @Value("${aliyun.sms.secret}")
    public String secret;

    @Bean
    public IClientProfile iClientProfile() {
        return DefaultProfile.getProfile(regionId, accessKeyId, secret);
    }

    public static void main(String[] args) {
        SpringApplication.run(SmsServiceApplication.class, args);
    }

}
