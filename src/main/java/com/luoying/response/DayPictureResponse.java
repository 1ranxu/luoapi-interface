package com.luoying.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 每日图片响应
 */
@Data
public class DayPictureResponse implements Serializable {
    // 日期
    private String date;

    // 标题
    private String title;

    // 链接
    private String url;

    private static final long serialVersionUID = 1L;
}
