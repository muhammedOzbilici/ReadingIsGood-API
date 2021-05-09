package com.example.readingisgoodapi.model;

import lombok.Data;

@Data
public class ResponseModel {
    private boolean isSuccessful;
    private String resultMessage;
}
