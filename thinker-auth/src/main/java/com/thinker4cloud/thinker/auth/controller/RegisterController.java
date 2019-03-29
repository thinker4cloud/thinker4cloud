package com.thinker4cloud.thinker.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.thinker4cloud.thinker.auth.enumeration.RegisterType;
import com.thinker4cloud.thinker.auth.service.AccountService;

/**
 * Created by dev@panjunye.com on 2019/03/29.
 */

@Controller
public class RegisterController {

    private final AccountService accountService;

    @Autowired
    public RegisterController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping
    public ModelAndView register(
            @RequestParam("type") RegisterType type,
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("password") String password,
            @RequestParam("verify_code") String verifyCode) {
        ModelAndView mav = new ModelAndView("register");
        switch (type) {
            case username:
                accountService.createUserByUsername(username, password);
                mav.setViewName("login");
                break;
            case email:
                break;
            case phone:
                break;
            default:
                break;
        }
        return mav;
    }
}
