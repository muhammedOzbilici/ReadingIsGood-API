package com.example.readingisgoodapi.validator;

import com.example.readingisgoodapi.dto.CustomerDto;
import com.example.readingisgoodapi.exception.MissingMandatoryFieldException;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {
    public void validate(CustomerDto customerDto) {
        if (customerDto == null) {
            throw new MissingMandatoryFieldException("missing.field");
        }
    }
}
