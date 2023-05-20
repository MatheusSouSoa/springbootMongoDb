package com.sysmap.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sysmap.demo.service.security.IJwtService;
import com.sysmap.demo.service.user.CreateUserRequest;
import com.sysmap.demo.service.user.FindUserResponse;
import com.sysmap.demo.service.user.IUserService;
import com.sysmap.demo.service.user._userValidator;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService _userService;

    @Autowired
    private IJwtService _jwtService;
    
    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request) throws Exception{

        if(_jwtService.isValidtoken(getToken(), getUserId())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuario não autenticado");
        } 

        if(!_userValidator.validate(request)){
            return ResponseEntity.badRequest().build();
        }

        var response = _userService.createUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping()
    public ResponseEntity<FindUserResponse> getUser(String email){
        return ResponseEntity.ok().body(_userService.findUserByEmail(email));
    }

    public String getToken(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
    }

    public String getUserId(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
                .getHeader("UserId");
    }
    
}
