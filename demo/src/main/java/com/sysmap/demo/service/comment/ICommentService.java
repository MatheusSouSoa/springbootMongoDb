package com.sysmap.demo.service.comment;

public interface ICommentService {

    String createUserComment(String email, CreateCommentRequest request);
}
