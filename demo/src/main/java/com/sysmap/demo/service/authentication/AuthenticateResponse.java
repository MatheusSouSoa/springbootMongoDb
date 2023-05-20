package com.sysmap.demo.service.authentication;

import java.util.UUID;

import lombok.Data;

@Data
public class AuthenticateResponse {
    
    public UUID userId;
    public String token;

}
