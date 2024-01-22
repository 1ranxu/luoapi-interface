package com.luoying.controller;

import cn.hutool.json.JSONUtil;
import com.luoying.model.params.*;
import com.luoying.model.response.NameResponse;
import com.luoying.model.response.RandomWallpaperResponse;
import com.luoying.utils.RequestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.luoying.utils.RequestUtils.buildUrl;
import static com.luoying.utils.ResponseUtils.getResponse;


/**
 * @Description:
 */
@RestController
@RequestMapping
public class ApiController {
    /**
     * 获取名字
     */
    @GetMapping("/name")
    public NameResponse getName(NameParams nameParams) {
        return JSONUtil.toBean(JSONUtil.toJsonStr(nameParams), NameResponse.class);
    }

    /**
     * 随机情话
     */
    @GetMapping("/loveTalk")
    public String randomLoveTalk() {
        return RequestUtils.get("https://api.vvhan.com/api/love");
    }

    /**
     * 毒鸡汤
     */
    @GetMapping("/poisonousChickenSoup")
    public String getPoisonousChickenSoup() {
        return RequestUtils.get("https://api.btstu.cn/yan/api.php?charset=utf-8&encode=json");
    }

    /**
     * 随机壁纸
     */
    @GetMapping("/randomWallpaper")
    public RandomWallpaperResponse randomWallpaper(RandomWallpaperParams randomWallpaperParams) {
        String baseUrl = "https://api.btstu.cn/sjbz/api.php";
        String url = buildUrl(baseUrl, randomWallpaperParams);
        if (StringUtils.isAllBlank(randomWallpaperParams.getLx(), randomWallpaperParams.getMethod())) {
            url = url + "?format=json";
        } else {
            url = url + "&format=json";
        }
        return JSONUtil.toBean(RequestUtils.get(url), RandomWallpaperResponse.class);
    }

    /**
     * 星座运势
     */
    @GetMapping("/horoscope")
    public String getHoroscope(HoroscopeParams horoscopeParams) {
        return getResponse("https://api.vvhan.com/api/horoscope", horoscopeParams);
    }

    /**
     * ip信息归属地
     */
    @GetMapping("/ipInfo")
    public String getIpInfo(IpInfoParams ipInfoParams) {
        return getResponse("https://api.vvhan.com/api/getIpInfo", ipInfoParams);
    }

    /**
     * 获取天气情况
     */
    @GetMapping("/weather")
    public String getWeatherInfo(WeatherParams weatherParams) {
        return getResponse("https://api.vvhan.com/api/weather", weatherParams);
    }
}
