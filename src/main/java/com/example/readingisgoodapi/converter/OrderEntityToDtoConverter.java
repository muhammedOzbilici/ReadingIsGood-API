package com.example.readingisgoodapi.converter;

import com.example.readingisgoodapi.dto.OrderDto;
import com.example.readingisgoodapi.entity.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityToDtoConverter implements Converter<Order, OrderDto> {

    @Override
    public OrderDto convert(Order coupon) {
        OrderDto orderDto = new OrderDto();
        return orderDto;
    }
}
