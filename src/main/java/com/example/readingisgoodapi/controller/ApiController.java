package com.example.readingisgoodapi.controller;

import com.example.readingisgoodapi.dto.CustomerDto;
import com.example.readingisgoodapi.dto.OrderDto;
import com.example.readingisgoodapi.entity.Book;
import com.example.readingisgoodapi.entity.OrderEntity;
import com.example.readingisgoodapi.model.OrderDetailModel;
import com.example.readingisgoodapi.model.ResponseModel;
import com.example.readingisgoodapi.service.*;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ApiController {
    private final SaveCustomerService saveCustomerService;
    private final PlaceOrderService placeOrderService;
    private final ListAllOrderService listAllOrderService;
    private final ViewOrderDetailService viewOrderDetailService;
    private final GetAllStocksService getAllStocksService;

    @PostMapping(value = "/save-customer")
    public ResponseEntity<String> saveCustomer(@RequestBody CustomerDto customerDto) {
        try {
            ResponseModel responseModel = saveCustomerService.saveCustomer(customerDto);
            if (responseModel.isSuccessful()) {
                return new ResponseEntity<>("Customer successfully saved.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(responseModel.getResultMessage(), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get-all-stocks")
    public List<Book> getAllStocks() {
        return getAllStocksService.getAllStocks();
    }

    @PostMapping(value = "/place-order")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto) {
        try {
            ResponseModel responseModel = placeOrderService.placeOrder(orderDto);
            if (responseModel.isSuccessful()) {
                return new ResponseEntity<>("Order successfully placed.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(responseModel.getResultMessage(), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/list-all-orders-by-customerid")
    @ApiOperation(value="List all orders by customerId and order status",
            notes = "This method return all orders by customerId and order status")
    public List<OrderEntity> listAllOrdersByCustomerId(@RequestParam Long customerId,
                                                       @RequestParam boolean isActiveOrder) {
        return listAllOrderService.listAllOrdersByCustomerId(customerId, isActiveOrder);
    }

    @GetMapping(value = "/view-order-details")
    public OrderDetailModel viewOrderDetails(@RequestParam Long orderId) {
        return viewOrderDetailService.viewOrderDetail(orderId);
    }
}
