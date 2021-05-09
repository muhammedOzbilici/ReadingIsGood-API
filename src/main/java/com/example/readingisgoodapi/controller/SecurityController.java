package com.example.readingisgoodapi.controller;

import com.example.readingisgoodapi.config.SecurityConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping(value = "/api")
public class SecurityController {

    @Autowired
    private SecurityConfig securityConfig;

    @PostMapping("/get-token")
    public String getToken(@RequestParam String username,
                           @RequestParam String password) {
        if (username.equals(securityConfig.getUsername()) && password.equals(securityConfig.getPassword())) {
            log.info("Username={} got token successfully.", username);
            return getJWTToken(username);
        } else {
            throw new UsernameNotFoundException("Username or password not correct");
        }
    }

    private String getJWTToken(String username) {
        String secretKey = "SnASfXPwu9SsYah9";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts.builder().setId("id").setSubject(username)
                .claim("authorities", grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + securityConfig.getExpirationTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
        return "Bearer token is -> " + token;
    }
}
