package com.sysmap.demo.service.user;

import com.sysmap.demo.entities.User;

public interface IUserService {
    String createUser(CreateUserRequest request) throws Exception;
    FindUserResponse findUserByEmail (String email);
    User getUser(String email);
}
