package com.example.readingisgoodapi.model;

import com.example.readingisgoodapi.entity.Address;
import com.example.readingisgoodapi.entity.Book;
import com.example.readingisgoodapi.entity.Customer;
import com.example.readingisgoodapi.entity.OrderEntity;
import lombok.Data;

@Data
public class OrderDetailModel {
    private OrderEntity orderEntity;
    private Customer customer;
    private Address address;
    private Book book;
}
