package com.luoying.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author 落樱的悔恨
 * @Date 2024/2/7 19:22
 * 获取网站标题请求参数
 */
@Data
@Accessors(chain = true)
public class AcquireWebsiteTitleParams implements Serializable {
    // 网站域名
    private String url;

    private static final long serialVersionUID = 1L;
}
