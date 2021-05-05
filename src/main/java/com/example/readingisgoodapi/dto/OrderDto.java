package com.example.readingisgoodapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDto {
    @NotNull
    private boolean isActive;
}
