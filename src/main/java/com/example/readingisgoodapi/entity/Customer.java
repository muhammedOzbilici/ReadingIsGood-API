package com.example.readingisgoodapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(length = 40, nullable = false)
    private String name;
    @Column(length = 40, nullable = false)
    private String surname;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;
    private LocalDateTime createdDate;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "addressId")
    private List<Address> addressList;
    private boolean isActive;

}
