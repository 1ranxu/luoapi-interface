package com.luoying.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author 落樱的悔恨
 * @Date 2024/2/7 19:22
 * 每日图片请求参数
 */
@Data
@Accessors(chain = true)
public class DayPictureParams implements Serializable {
    // 随机输出:sj
    private String rand;

    // 图片尺寸：1920x1200, 1920x1080, 1366x768, 1280x768, 1024x768, 800x600, 800x480, 768x1280, 720x1280, 640x480, 480x800, 400x240, 320x240, 240x320
    private String size;

    private static final long serialVersionUID = 1L;
}
