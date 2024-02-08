package com.luoying.controller;

import cn.hutool.json.JSONUtil;
import com.luoying.model.params.*;
import com.luoying.response.AcquireWebsiteTitleResponse;
import com.luoying.response.DayPictureResponse;
import com.luoying.response.JokeResponse;
import com.luoying.response.RandomWallpaperResponse;
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
    public String getName(NameParams nameParams) {
        return JSONUtil.toJsonStr(nameParams);
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

    /**
     * 随机头像
     */
    @GetMapping("/randomAvatar")
    public String randomAvatar(RandomAvatarParams randomAvatarParams) {
        String baseUrl = "https://api.vvhan.com/api/avatar";
        if (StringUtils.isAllBlank(randomAvatarParams.getSort())) {
            baseUrl = baseUrl + "?type=json";
        } else {
            baseUrl = baseUrl + "?type=json&class=" + randomAvatarParams.getSort();
        }
        return getResponse(baseUrl, null);
    }


    /**
     * 随机高清风景图片
     */
    @GetMapping("/randomScenery")
    public String randomScenery() {
        return getResponse("https://api.vvhan.com/api/view?type=json", null);
    }

    /**
     * 随机高清二次元图片
     */
    @GetMapping("/random2D")
    public String random2D() {
        return getResponse("https://api.vvhan.com/api/acgimg?type=json", null);
    }

    /**
     * 每日图片
     */
    @GetMapping("/dayPicture")
    public DayPictureResponse dayPicture(DayPictureParams dayPictureParams) {
        String baseUrl = "https://api.vvhan.com/api/bing";
        String url = buildUrl(baseUrl, dayPictureParams);
        if (StringUtils.isAllBlank(dayPictureParams.getRand(), dayPictureParams.getSize())) {
            url = url + "?type=json";
        } else {
            url = url + "&type=json";
        }
        return JSONUtil.toBean(getResponse(url, null), DayPictureResponse.class);
    }


    /**
     * 随机笑话
     */
    @GetMapping("/joke")
    public JokeResponse joke() {
        return JSONUtil.toBean(RequestUtils.get("https://api.vvhan.com/api/joke?type=json"), JokeResponse.class);
    }

    /**
     * 垃圾分类
     */
    @GetMapping("/wasteSorting")
    public String wasteSorting(WasteSortingParams wasteSortingParams) {
        return getResponse("https://api.vvhan.com/api/la.ji", wasteSortingParams);
    }

    /**
     * 获取网站标题
     */
    @GetMapping("/acquireWebsiteTitle")
    public AcquireWebsiteTitleResponse AcquireWebsiteTitle(AcquireWebsiteTitleParams acquireWebsiteTitleParams) {
        return JSONUtil.toBean(getResponse("https://api.vvhan.com/api/title", acquireWebsiteTitleParams), AcquireWebsiteTitleResponse.class);
    }

    /**
     * 每日励志英语
     */
    @GetMapping("/inspiringEnglish")
    public String inspiringEnglish(InspiringEnglishParams inspiringEnglishParams) {
        return getResponse("https://api.vvhan.com/api/en", inspiringEnglishParams);
    }

}
