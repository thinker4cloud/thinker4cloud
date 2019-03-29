package com.thinker4cloud.thinker.sms.controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dev@panjunye.com on 2019/03/29.
 */

@RestController
public class SmsController {


    private final IClientProfile iClientProfile;

    @Autowired
    public SmsController(IClientProfile iClientProfile) {
        this.iClientProfile = iClientProfile;
    }

    @RequestMapping("sms/send")
    public void sendSms(@RequestParam("phone_number") String phone_number) {

        IAcsClient client = new DefaultAcsClient(iClientProfile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone_number);
        request.putQueryParameter("TemplateCode", "递四方速递");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
