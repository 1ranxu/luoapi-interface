package com.luoying.utils;

import cn.hutool.http.HttpRequest;
import com.luoying.exception.ApiException;
import com.luoying.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class RequestUtils {

    /**
     * 生成url
     */
    public static <T> String buildUrl(String baseUrl, T params) {
        if(params == null){
            return baseUrl;
        }
        StringBuilder url = new StringBuilder(baseUrl);
        // 使用反射获取类的变量
        Field[] fields = params.getClass().getDeclaredFields();
        boolean isFirstParam = true;
        // 遍历所有参数字段
        for (Field field : fields) {
            // 设置可以访问私有变量
            field.setAccessible(true);
            // 获取变量名
            String name = field.getName();
            // 跳过serialVersionUID属性
            if ("serialVersionUID".equals(name)) {
                continue;
            }
            // 构建url参数
            try {
                // 获取变量值
                Object value = field.get(params);
                if (value != null) {// 不为空
                    if (isFirstParam) {// 是第一个参数
                        url.append("?").append(name).append("=").append(value);
                        isFirstParam = false;
                    } else { // 不是第一个参数
                        url.append("&").append(name).append("=").append(value);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new ApiException(ErrorCode.OPERATION_ERROR, "构建url异常");
            }
        }
        return url.toString();
    }

    /**
     * get请求
     *
     * @param baseUrl 基本url
     * @param params  params
     */
    public static <T> String get(String baseUrl, T params){
        return get(buildUrl(baseUrl, params));
    }

    /**
     * get请求
     *
     * @param url url
     */
    public static String get(String url) {
        String body = HttpRequest.get(url).execute().body();
        log.info("【interface】：请求地址：{}，响应数据：{}", url, body);
        return body;
    }
}
