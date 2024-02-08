package com.luoying.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 随机壁纸响应
 */
@Data
public class RandomWallpaperResponse implements Serializable {
    // 图片链接
    private String imgurl;

    private static final long serialVersionUID = 1L;
}
