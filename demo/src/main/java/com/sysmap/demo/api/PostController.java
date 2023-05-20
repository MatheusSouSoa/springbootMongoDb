package com.sysmap.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysmap.demo.service.post.IPostService;
import com.sysmap.demo.service.post.createPostRequest;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    
    @Autowired
    private IPostService _postService;

    @PostMapping("/new/{email}")
    public ResponseEntity<String> createPost(@PathVariable String email, @RequestBody createPostRequest request){

        var response = _postService.createPost(email, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
