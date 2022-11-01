package com.example.yuye.biz.mapping;

import com.example.yuye.biz.request.CreateOrderRequest;
import com.example.yuye.dal.entity.PayOrder;
import com.example.yuye.domain.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zhouliang
 * @date 2022/7/27 10:29 AM
 */
@Mapper
public interface PayOrderMapping {
    PayOrderMapping INSTANCE = Mappers.getMapper(PayOrderMapping.class);

    Order toOrder(CreateOrderRequest request);
}
