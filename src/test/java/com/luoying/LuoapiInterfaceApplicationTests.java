package com.luoying;


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
    public void testNameInterface(){
        Map<String, Object> params=new HashMap<>();
        params.put("name","冉旭");
        LuoApiRequest currencyRequest = new LuoApiRequest();
        currencyRequest.setMethod("GET");
        currencyRequest.setPath("/api/name");
        currencyRequest.setRequestParams(params);
        apiService.request(currencyRequest);
    }

    @Test
    public void testWallPaperInterface(){
        Map<String, Object> params=new HashMap<>();
        params.put("method","pc");
        params.put("lx","dongman");
        LuoApiRequest currencyRequest = new LuoApiRequest();
        currencyRequest.setMethod("GET");
        currencyRequest.setPath("/api/randomWallpaper");
        currencyRequest.setRequestParams(params);
        apiService.request(currencyRequest);
    }
}
