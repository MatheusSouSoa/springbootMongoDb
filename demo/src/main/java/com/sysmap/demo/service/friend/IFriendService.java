package com.sysmap.demo.service.friend;


public interface IFriendService {

    String createFriend(String email, CreateFriendRequest request);
    FindUserResponse findUserByEmail (String email);

}
