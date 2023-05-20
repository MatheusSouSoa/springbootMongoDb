package com.sysmap.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysmap.demo.service.friend.CreateFriendRequest;
import com.sysmap.demo.service.friend.IFriendService;

@RestController
@RequestMapping("/api/v1/friends")
public class FriendController {
    
    @Autowired
    private IFriendService _friendService;

    @PostMapping("/new/{email}")
    public ResponseEntity<String> addFriend(@PathVariable String email, @RequestBody CreateFriendRequest request) {
        var response = _friendService.createFriend(email, request);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
