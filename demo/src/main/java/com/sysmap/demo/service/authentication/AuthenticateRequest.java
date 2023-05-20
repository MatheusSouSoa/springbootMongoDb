package com.sysmap.demo.service.authentication;

import lombok.Data;

@Data
public class AuthenticateRequest {
    
    public String email;
    public String password;

}
