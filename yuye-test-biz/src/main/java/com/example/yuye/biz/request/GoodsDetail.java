package com.example.yuye.biz.request;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhouliang
 * @date 2022/8/3 3:44 PM
 */
@Data
@Builder
public class GoodsDetail {
    private Integer id;
    private String name;
}
