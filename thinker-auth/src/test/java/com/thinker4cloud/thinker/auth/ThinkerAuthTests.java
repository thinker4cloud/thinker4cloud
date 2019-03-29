package com.thinker4cloud.thinker.auth;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by dev@panjunye.com on 2019/03/27.
 */

public class ThinkerAuthTests {
    @Test
    public void test(){
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
