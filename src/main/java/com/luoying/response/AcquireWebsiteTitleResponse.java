package com.luoying.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取网站标题响应
 */
@Data
public class AcquireWebsiteTitleResponse implements Serializable {
    // 标题
    private String title;

    private static final long serialVersionUID = 1L;
}
