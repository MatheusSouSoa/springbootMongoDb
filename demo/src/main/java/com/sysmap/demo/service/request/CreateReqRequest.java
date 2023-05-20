package com.sysmap.demo.service.request;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateReqRequest {

    public UUID id;
    public String name;
    public String email;
    public String profilePicture;

}