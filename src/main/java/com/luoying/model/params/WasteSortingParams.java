package com.luoying.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author 落樱的悔恨
 * @Date 2024/2/7 21:41
 * 垃圾分类请求参数
 */
@Data
@Accessors(chain = true)
public class WasteSortingParams implements Serializable {
    // 垃圾名字
    private String lj;

    private static final long serialVersionUID = 1L;
}
