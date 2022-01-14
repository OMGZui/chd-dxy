package com.e.dxy.service;

import com.e.dxy.DxyApplicationTests;
import com.e.dxy.domain.UserDomain;
import com.e.dxy.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserTest extends DxyApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void testDetail(){
        UserDomain userDomain = userService.getIfPresent(1);
        System.out.println(userDomain.toString());
    }
}
