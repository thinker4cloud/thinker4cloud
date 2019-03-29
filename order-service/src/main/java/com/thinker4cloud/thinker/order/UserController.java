package com.thinker4cloud.thinker.order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dev@panjunye.com on 2019/03/28.
 */

@RestController
public class UserController {

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
