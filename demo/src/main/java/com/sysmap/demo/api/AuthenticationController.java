package com.sysmap.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysmap.demo.service.authentication.AuthenticateRequest;
import com.sysmap.demo.service.authentication.AuthenticateResponse;
import com.sysmap.demo.service.authentication.IAuthenticationService;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {
    
    @Autowired
    private IAuthenticationService _authenticationService;

    @PostMapping()
    public ResponseEntity<AuthenticateResponse> login(@RequestBody AuthenticateRequest request){
        return ResponseEntity.ok().body(_authenticationService.login(request));
    }

}
