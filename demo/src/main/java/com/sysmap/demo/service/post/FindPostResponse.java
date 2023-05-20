package com.sysmap.demo.service.post;

import java.util.UUID;

public class FindPostResponse {
    public UUID originId;
    public String content;
    public String img;

    public FindPostResponse(UUID id, String name, String email) {
        this.originId = id;
        this.content = name;
        this.img = email;
    }

    
}
