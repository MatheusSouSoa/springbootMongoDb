package com.sysmap.demo.entities;

import java.util.UUID;

import lombok.Data;

@Data
public class Request {

    private UUID id;
    private UUID authorId;
    private String name;
    private String profilePicture;


    public Request(UUID authorId, String name, String profilePicture) {
        this.setId();
        this.authorId = authorId;
        this.name = name;
        this.profilePicture = profilePicture;
    }

    protected void setId() {
        this.id = UUID.randomUUID();
    }

}
