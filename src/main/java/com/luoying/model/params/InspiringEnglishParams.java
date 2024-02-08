package com.luoying.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author 落樱的悔恨
 * @Date 2024/2/7 19:22
 * 每日一句励志英语请求参数
 */
@Data
@Accessors(chain = true)
public class InspiringEnglishParams implements Serializable {
    // 是否随机输出
    private String type;

    private static final long serialVersionUID = 1L;
}
