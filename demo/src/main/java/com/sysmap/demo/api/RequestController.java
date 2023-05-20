package com.sysmap.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysmap.demo.service.request.CreateReqRequest;
import com.sysmap.demo.service.request.IRequestService;

@RestController
@RequestMapping("/api/v1/requests")
public class RequestController {
    
    @Autowired
    private IRequestService _requestService;

    @PostMapping("/new/{email}")
    public ResponseEntity<String> createPost(@PathVariable String email, @RequestBody CreateReqRequest request) {

        var response = _requestService.createRequest(email, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
}
