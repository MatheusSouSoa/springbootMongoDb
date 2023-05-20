package com.sysmap.demo.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmap.demo.service.security.IJwtService;
import com.sysmap.demo.service.user.IUserService;

@Service
public class AuthenticationService implements IAuthenticationService{
    
    @Autowired
    private IUserService _userService;

    @Autowired
    private IJwtService _jwtService;

    public AuthenticateResponse login (AuthenticateRequest request){
        var user = _userService.getUser(request.email);
        

        if(user == null){
            return null;//mudar para resposta http
        }

        if(!user.getPassword().equals(request.password)){
            return null;//mudar para resposta http
        }

        var token = _jwtService.generateToken(user.getId());

        var response = new AuthenticateResponse();

        response.setUserId(user.getId());
        response.setToken(token);

        return response;
    }

}
