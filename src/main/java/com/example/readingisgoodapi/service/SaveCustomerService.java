package com.example.readingisgoodapi.service;

import com.example.readingisgoodapi.converter.CustomerDtoToEntityConverter;
import com.example.readingisgoodapi.dto.CustomerDto;
import com.example.readingisgoodapi.entity.Customer;
import com.example.readingisgoodapi.model.ResponseModel;
import com.example.readingisgoodapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveCustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoToEntityConverter customerDtoToEntityConverter;

    public ResponseModel saveCustomer(CustomerDto customerDto) {
        ResponseModel responseModel = new ResponseModel();
        String email = customerDto.getEmail();
        String phone = customerDto.getPhone();
        Optional<Customer> foundedCustomerByEmail = customerRepository.findByEmailOrPhone(email, phone);
        if (foundedCustomerByEmail.isPresent()) {
            log.info("There is a customer with this email={},phone={} already", email, phone);
            responseModel.setResultMessage("There is a customer with this email/phone already.");
            responseModel.setSuccessful(false);
        } else {
            log.info("Saving customer...");
            responseModel.setSuccessful(true);
            customerRepository.saveAndFlush(Objects.requireNonNull(customerDtoToEntityConverter.convert(customerDto)));
        }
        return responseModel;
    }
}
