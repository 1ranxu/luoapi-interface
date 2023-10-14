package com.luoying;

import com.luoying.client.LuoApiClient;
import com.luoying.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class LuoapiInterfaceApplicationTests {

    @Resource
    private LuoApiClient luoApiClient;
    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("冉旭");
        luoApiClient.getUsernameByPost(user);
    }

}
