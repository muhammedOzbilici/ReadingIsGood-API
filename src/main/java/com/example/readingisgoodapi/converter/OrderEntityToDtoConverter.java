package com.example.readingisgoodapi.converter;

import com.example.readingisgoodapi.dto.OrderDto;
import com.example.readingisgoodapi.entity.OrderEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityToDtoConverter implements Converter<OrderEntity, OrderDto> {

    @Override
    public OrderDto convert(OrderEntity orderEntity) {
        OrderDto orderDto = new OrderDto();
        return orderDto;
    }
}
