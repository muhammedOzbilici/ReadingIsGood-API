package com.example.readingisgoodapi.service;

import com.example.readingisgoodapi.entity.OrderEntity;
import com.example.readingisgoodapi.repository.OrderEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListAllOrderService {
    private final OrderEntityRepository orderEntityRepository;

    public List<OrderEntity> listAllOrdersByCustomerId(Long customerId, boolean isActiveOrder) {
        return orderEntityRepository.findByCustomerIdAndActive(customerId, isActiveOrder);
    }

}
