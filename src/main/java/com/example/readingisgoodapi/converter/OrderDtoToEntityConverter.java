package com.example.readingisgoodapi.converter;

import com.example.readingisgoodapi.dto.OrderDto;
import com.example.readingisgoodapi.entity.OrderEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderDtoToEntityConverter implements Converter<OrderDto, OrderEntity> {
    @Override
    public OrderEntity convert(OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setAddressId(orderDto.getAddressId());
        orderEntity.setBookId(orderDto.getBookId());
        orderEntity.setCustomerId(orderDto.getCustomerId());
        orderEntity.setActive(true);
        orderEntity.setOrderDate(LocalDateTime.now());
        return orderEntity;
    }
}
