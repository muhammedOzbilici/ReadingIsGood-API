package com.example.readingisgoodapi.converter;

import com.example.readingisgoodapi.dto.CustomerDto;
import com.example.readingisgoodapi.entity.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityToDtoConverter implements Converter<Customer, CustomerDto> {

    @Override
    public CustomerDto convert(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setPhone(customer.getPhone());
        return customerDto;
    }
}
