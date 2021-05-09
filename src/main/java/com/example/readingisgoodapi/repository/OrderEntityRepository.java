package com.example.readingisgoodapi.repository;

import com.example.readingisgoodapi.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByCustomerIdAndActive(Long customerId, boolean active);
}
