package com.example.readingisgoodapi.service;

import com.example.readingisgoodapi.base.BaseMockitoTest;
import com.example.readingisgoodapi.converter.CustomerEntityToDtoConverter;
import com.example.readingisgoodapi.entity.Address;
import com.example.readingisgoodapi.entity.Customer;
import com.example.readingisgoodapi.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public class SaveCustomerServiceTest extends BaseMockitoTest {

    @InjectMocks
    private SaveCustomerService saveCustomerService;

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerEntityToDtoConverter customerEntityToDtoConverter;

    public Customer entity;

    @Before
    public void before() {
        entity = new Customer();
        entity.setCustomerId(1L);
        List<Address> addressList = new ArrayList<>();
        Address address = new Address();
        address.setAddress("barbaros caddesi");
        address.setAddressId(1L);
        address.setCustomerId(1L);
        address.setActive(true);
        addressList.add(address);
        entity.setAddressList(addressList);
        entity.setPhone("05051112233");
        entity.setCreatedDate(LocalDateTime.now());
        entity.setSurname("kara");
        entity.setName("ahmet");
        entity.setEmail("ahmet@gmail.com");
        entity.setActive(true);
        entity.setActive(true);
    }

    @Test
    public void it_should_save_customer() {
        //given
        List<Address> addressList = new ArrayList<>();
        Address address = new Address();
        address.setAddress("barbaros caddesi");
        address.setAddressId(1L);
        address.setCustomerId(1L);
        address.setActive(true);
        addressList.add(address);
        Customer customer = new Customer(1L, "ahmet", "kara", "05051112233", "ahmet@gmail.com", LocalDateTime.now(), addressList, true);

        //when
        saveCustomerService.saveCustomer(customerEntityToDtoConverter.convert(entity));

        //then
        verify(customerRepository).save(entity);

    }

}
