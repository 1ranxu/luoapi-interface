package com.luoying.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luoying.exception.ApiException;
import com.luoying.exception.ErrorCode;

import java.util.Map;

public class ResponseUtils {
    /**
     * Json字符串转Map
     *
     * @param response 响应结果
     */
    public static Map<String, Object> responseToMap(String response) {
        return new Gson().fromJson(response, new TypeToken<Map<String, Object>>() {
        }.getType());
    }

    public static <T> String getResponse(String baseUrl, T params) {
        try {
            // 获取响应（Json字符串）
            String response = RequestUtils.get(baseUrl, params);
            // Json字符串转Map
            Map<String, Object> fromResponse = responseToMap(response);
            // 数据处理
            if (fromResponse.containsKey("success")) {
                fromResponse.remove("success");
            }
            if (fromResponse.containsKey("data")) {
                return new Gson().toJson(fromResponse.get("data"));
            }
            return new Gson().toJson(fromResponse);
        } catch (ApiException e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "构建url异常");
        }
    }
}
