package com.example.readingisgoodapi.controller;

import com.example.readingisgoodapi.service.GiveOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ApiController {
    private final GiveOrderService giveOrderService;

    @PostMapping(value = "/give-order")
    public void giveOrder() {
        log.info("Giving order");
    }

}
