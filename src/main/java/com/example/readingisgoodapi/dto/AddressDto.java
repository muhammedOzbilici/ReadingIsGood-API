package com.example.readingisgoodapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddressDto {
    @NotNull
    private Long customerId;
    @NotNull
    private String address;
    @NotNull
    private boolean isActive;

}
