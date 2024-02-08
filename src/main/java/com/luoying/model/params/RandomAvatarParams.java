package com.luoying.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 随机头像请求参数
 */
@Data
@Accessors(chain = true)
public class RandomAvatarParams implements Serializable {
    // 头像种类 nan-男头 nv-女头 dm-动漫 jw-景物
    private String sort;

    private static final long serialVersionUID = 1L;
}
