package com.example.readingisgoodapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class OrderDto {
    @NotNull
    @NotBlank(message = "error.validation.customer.id.not.blank")
    private Long customerId;
    @NotNull
    @NotBlank(message = "error.validation.address.id.not.blank")
    private Long addressId;
    @NotNull
    @NotBlank(message = "error.validation.book.id.not.blank")
    private Long bookId;
}
