package com.sysmap.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysmap.demo.service.comment.CreateCommentRequest;
import com.sysmap.demo.service.comment.ICommentService;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    
    @Autowired
    private ICommentService _commentService;

    @PostMapping("/new/user/{id}")
    public ResponseEntity<String> addUserComment(@PathVariable String email, @RequestBody CreateCommentRequest request) {
        var response = _commentService.createUserComment(email, request);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
