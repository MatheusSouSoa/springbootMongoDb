package com.sysmap.demo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class Post {

    private UUID id;
    private String content;
    private String img;
    private List<Comment> comments;
    private List<Like> likes;

    public Post(String content, String img) {
        this.setId();
        this.content = content;
        this.img = img;
        this.comments = new ArrayList<>();
        this.likes = new ArrayList<>();
    }

    protected void setId() {
        this.id = UUID.randomUUID();
    }

}
