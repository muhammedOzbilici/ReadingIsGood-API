package com.example.readingisgoodapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("security")
public class SecurityConfig {
    private String username;
    private String password;
    private int expirationTimeMillis;
}
