package com.example.readingisgoodapi.service;

import com.example.readingisgoodapi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GiveOrderService {
    private final OrderRepository orderRepository;

    public void giveOrder() {

    }
}
