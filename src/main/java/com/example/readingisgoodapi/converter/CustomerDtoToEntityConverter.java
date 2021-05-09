package com.example.readingisgoodapi.converter;

import com.example.readingisgoodapi.dto.CustomerDto;
import com.example.readingisgoodapi.entity.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerDtoToEntityConverter implements Converter<CustomerDto, Customer> {
    @Override
    public Customer convert(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setCreatedDate(LocalDateTime.now());
        customer.setAddressList(customerDto.getAddressList());
        customer.setActive(true);
        return customer;
    }
}
