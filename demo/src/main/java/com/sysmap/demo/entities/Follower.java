package com.sysmap.demo.entities;

import java.util.UUID;

import lombok.Data;

@Data
public class Follower {

    private UUID id;
    private String name;
    private String email;
    private String profilePicture;

    public Follower(UUID id, String name, String email, String profilePicture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profilePicture = profilePicture;
    }

}
