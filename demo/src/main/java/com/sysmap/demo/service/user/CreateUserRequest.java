package com.sysmap.demo.service.user;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateUserRequest {
    
    public String name;
    public String email;
    public String password;
    public UUID createdTo;

}
