package com.example.readingisgoodapi.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class BookDto {
    @NotNull
    private String name;
    @NotNull
    private String author;
    @NotNull
    private LocalDate publishYear;
    @NotNull
    private int stock;
    @NotNull
    private boolean isActive;

}
