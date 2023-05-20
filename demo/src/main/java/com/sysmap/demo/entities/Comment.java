package com.sysmap.demo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class Comment {

    private UUID id;
    private UUID originId;
    private String content;
    private String img;
    private List<Like> likes;
    private List<Reply> replies;


    public Comment(UUID originID, String content, String img) {
        this.setId();
        this.originId = originID;
        this.content = content;
        this.img = img;
        this.likes = new ArrayList<>();
        this.replies = new ArrayList<>();
    }

    protected void setId() {
        this.id = UUID.randomUUID();
    }

}
