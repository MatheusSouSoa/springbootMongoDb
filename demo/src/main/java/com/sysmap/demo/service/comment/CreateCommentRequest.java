package com.sysmap.demo.service.comment;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateCommentRequest {
   
    public UUID originId;
    public String content;
    public String img;
}
