package com.sysmap.demo.service.follow;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateFollowRequest {

    public UUID id;
    public String name;
    public String email;
    public String profilePicture;

}
