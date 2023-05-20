package com.sysmap.demo.entities;

import java.util.UUID;

import lombok.Data;

@Data
public class Following {

    private UUID id;
    private String name;
    private String email;
    private String profilePicture;

    public Following(UUID id, String name, String email, String profilePicture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profilePicture = profilePicture;
    }

}
