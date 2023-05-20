package com.sysmap.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysmap.demo.service.follow.CreateFollowRequest;
import com.sysmap.demo.service.follow.IFollowService;

@RestController
@RequestMapping("/api/v1/follows")
public class FollowController {
    
    @Autowired
    private IFollowService _followService;

    @PostMapping("/new/{email}")
    public ResponseEntity<String> addFollower(@PathVariable String email, @RequestBody CreateFollowRequest request) {
        var response = _followService.createFollowed(email, request);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
