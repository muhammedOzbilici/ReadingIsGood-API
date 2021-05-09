package com.example.readingisgoodapi.service;

import com.example.readingisgoodapi.entity.Address;
import com.example.readingisgoodapi.entity.Book;
import com.example.readingisgoodapi.entity.Customer;
import com.example.readingisgoodapi.entity.OrderEntity;
import com.example.readingisgoodapi.model.OrderDetailModel;
import com.example.readingisgoodapi.repository.AddressRepository;
import com.example.readingisgoodapi.repository.BookRepository;
import com.example.readingisgoodapi.repository.CustomerRepository;
import com.example.readingisgoodapi.repository.OrderEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ViewOrderDetailService {
    private final OrderEntityRepository orderEntityRepository;
    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;
    private final AddressRepository addressRepository;

    public OrderDetailModel viewOrderDetail(Long orderId) {
        OrderDetailModel orderDetailModel = new OrderDetailModel();
        Optional<OrderEntity> foundedOrder = orderEntityRepository.findById(orderId);
        if (foundedOrder.isPresent()) {
            OrderEntity foundedOrderEntity = foundedOrder.get();
            orderDetailModel.setOrderEntity(foundedOrderEntity);
            Customer foundedCustomer = customerRepository.findById(foundedOrderEntity.getCustomerId()).get();
            Book foundedBook = bookRepository.findById(foundedOrderEntity.getBookId()).get();
            Address foundedAddress = addressRepository.findById(foundedOrderEntity.getAddressId()).get();
            orderDetailModel.setCustomer(foundedCustomer);
            orderDetailModel.setBook(foundedBook);
            orderDetailModel.setAddress(foundedAddress);
        } else {
            log.info("Couldn't find this order, orderId={}", orderId);
        }
        return orderDetailModel;
    }

}
