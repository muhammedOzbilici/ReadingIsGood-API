package com.example.readingisgoodapi.validator;

import com.example.readingisgoodapi.dto.OrderDto;
import com.example.readingisgoodapi.exception.MissingMandatoryFieldException;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {
    public void validate(OrderDto orderDto) {
        if (orderDto == null) {
            throw new MissingMandatoryFieldException("missing.field");
        }
    }
}
