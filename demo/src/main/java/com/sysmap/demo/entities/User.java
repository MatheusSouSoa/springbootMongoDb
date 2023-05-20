package com.sysmap.demo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class User {
    
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String profilePicture;
    private List<Friend> friends;
    private List<Follower> followers;
    private List<Following> following;
    private List<Request> requests;
    private List<Post> posts;
    private List<Comment> comments;
    private List<Like> likes;


    public User(String name, String email, String password) {
        this.setId();
        this.name = name;
        this.email = email;
        this.password = password;
        this.friends = new ArrayList<Friend>();
        this.followers = new ArrayList<Follower>();
        this.following = new ArrayList<Following>();
        this.requests = new ArrayList<Request>();
        this.posts = new ArrayList<Post>();
        this.comments = new ArrayList<Comment>();
        this.likes = new ArrayList<Like>();
    }

    protected void setId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId(){
        return this.id;
    }

}
