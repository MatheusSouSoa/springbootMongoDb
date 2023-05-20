package com.sysmap.demo.service.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmap.demo.data.UserRepository;
import com.sysmap.demo.entities.User;

@Service
public class UserService implements IUserService{
    
    @Autowired
    private UserRepository _userRepository;

    public String createUser(CreateUserRequest request) throws Exception{
        var user = new User(request.name, request.email, request.password);

        if(!_userRepository.findUserByEmail(request.email).isEmpty()){
            throw new Exception("Usuario ja existe");
        }

        _userRepository.save(user);

        return user.getId().toString();
    }

    public FindUserResponse findUserByEmail (String email){
       var user = _userRepository.findUserByEmail(email).get();
        
       var response = new FindUserResponse(user.getId(),user.getName(), user.getEmail());

       return response;
    }

    public User getUser(String email){
        return _userRepository.findUserByEmail(email).get();
    }



}
