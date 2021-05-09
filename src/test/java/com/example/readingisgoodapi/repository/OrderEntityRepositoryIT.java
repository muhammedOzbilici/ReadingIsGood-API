package com.example.readingisgoodapi.repository;

import com.example.readingisgoodapi.entity.OrderEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class OrderEntityRepositoryIT {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void it_should_save_order_entity_successfully() {

        //arrange
        OrderEntity savedOrderEntity = new OrderEntity(1L, 1L, 1L, 1L, LocalDateTime.now(), true);
        jdbcTemplate.execute("insert into order (ORDER_ID,CUSTOMER_ID,ADDRESS_ID,BOOK_ID,ORDER_DATE,ACTIVE) values (1L, 1L, 1L, 1L, LocalDateTime.now(), true)");

        //act
        Optional<OrderEntity> foundedOrderEntity = orderEntityRepository.findById(1L);

        //assert
        Optional<OrderEntity> orderEntity = foundedOrderEntity;
        Assert.assertEquals(orderEntity, foundedOrderEntity);

    }

}
