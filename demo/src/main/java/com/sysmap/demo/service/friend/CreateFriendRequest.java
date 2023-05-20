package com.sysmap.demo.service.friend;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateFriendRequest {

    public UUID id;
    public String name;
    public String email;
    public String profilePicture;

}
