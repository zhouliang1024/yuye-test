package com.example.yuye.dal.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;



/**
 * @author zhouliang
 * @date 2022/7/25 10:48 AM
 */
@Data
public class Goods {
    @TableId(value = "goods_id", type = IdType.ASSIGN_ID)
    private Long goodsId;
    private String goodsName;
    private Long goodsType;
}

