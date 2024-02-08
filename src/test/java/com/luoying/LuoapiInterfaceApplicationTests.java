package com.luoying;


import com.luoying.client.LuoApiClient;
import com.luoying.model.request.LuoApiRequest;
import com.luoying.service.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
class LuoapiInterfaceApplicationTests {
    @Resource
    private ApiService apiService;

    @Test
    public void testNameInterface() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "冉旭");
        LuoApiRequest luoApiRequest = new LuoApiRequest();
        luoApiRequest.setMethod("GET");
        luoApiRequest.setPath("/api/name");
        luoApiRequest.setRequestParams(params);
        log.info(apiService.request(luoApiRequest).toString());
    }

    @Test
    public void testWallPaperInterface() {
        LuoApiClient luoApiClient = new LuoApiClient("3b2ee0c7a23a59acb0c671c4dbbb1058", "dbf61b649aaf6a97eaa91f2584832059");
        Map<String, Object> params = new HashMap<>();
        params.put("method", "pc");
        params.put("lx", "dongman");
        LuoApiRequest luoApiRequest = new LuoApiRequest();
        luoApiRequest.setMethod("GET");
        luoApiRequest.setPath("http://gateway.luoapi.icu/api/randomWallpaper");
        luoApiRequest.setRequestParams(params);
        log.info(apiService.request(luoApiClient, luoApiRequest).toString());
    }

    @Test
    public void testAvatarInterface() {
        LuoApiClient luoApiClient = new LuoApiClient("f892dc6bfca970dc3378b3250d0be3f9", "b7792a1ce51202b175e1cbf866b0ee27");
        Map<String, Object> params = new HashMap<>();
        LuoApiRequest luoApiRequest = new LuoApiRequest();
        luoApiRequest.setMethod("GET");
        luoApiRequest.setPath("http://localhost:8012/api/randomAvatar");
        luoApiRequest.setRequestParams(params);
        log.info(apiService.request(luoApiClient, luoApiRequest).toString());
    }
}
