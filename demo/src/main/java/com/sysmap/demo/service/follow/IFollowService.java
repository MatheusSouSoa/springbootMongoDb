package com.sysmap.demo.service.follow;

public interface IFollowService {

    String createFollowed(String email, CreateFollowRequest request);
    FindUserResponse findUserByEmail(String email);
    void createFollowing(String email, CreateFollowRequest request);

}
