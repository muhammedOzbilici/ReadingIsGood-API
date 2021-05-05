package com.example.readingisgoodapi.converter;

import com.example.readingisgoodapi.dto.OrderDto;
import com.example.readingisgoodapi.entity.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoToEntityConverter implements Converter<OrderDto, Order> {
    @Override
    public Order convert(OrderDto orderDto) {
        Order order = new Order();
        return order;
    }
}
