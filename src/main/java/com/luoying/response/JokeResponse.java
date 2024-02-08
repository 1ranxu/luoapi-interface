package com.luoying.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 落樱的悔恨
 * @Date 2024/2/7 19:01
 * 随机笑话响应
 */
@Data
public class JokeResponse implements Serializable {
    // 标题
    private String title;

    // 内容
    private String joke;

    private static final long serialVersionUID = 1L;
}
