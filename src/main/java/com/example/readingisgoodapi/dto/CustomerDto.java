package com.example.readingisgoodapi.dto;

import com.example.readingisgoodapi.entity.Address;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CustomerDto {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private List<Address> addressList;
}
