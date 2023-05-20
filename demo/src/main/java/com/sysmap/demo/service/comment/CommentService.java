package com.sysmap.demo.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmap.demo.data.CommentRepository;
import com.sysmap.demo.entities.Comment;
import com.sysmap.demo.entities.User;

@Service
public class CommentService implements ICommentService {
    
    @Autowired
    private CommentRepository _commentRepository;

    public String createUserComment(String email, CreateCommentRequest request) {

        User user = _commentRepository.findUserByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        var comment = new Comment(request.originId, request.getContent(), request.getImg());

        user.getComments().add(comment);
        _commentRepository.save(user);

        return user.getName()+ " comentou na publicação "+ comment.getId();
    }

}
