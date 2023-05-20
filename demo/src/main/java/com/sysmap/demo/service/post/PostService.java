package com.sysmap.demo.service.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmap.demo.data.PostRepository;
import com.sysmap.demo.entities.Post;
import com.sysmap.demo.entities.User;

@Service
public class PostService implements IPostService{
    
    @Autowired
    private PostRepository _postRepository;

    public String createPost(String email, createPostRequest request){
        var post = new Post(request.content, request.img);

        User user = _postRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        user.getPosts().add(post);
        _postRepository.save(user);
        post.getComments();

        return "Post criado com sucesso";
    }


    public FindPostResponse findUserByEmail(String email) {
        var user = _postRepository.findUserByEmail(email).get();

        var response = new FindPostResponse(user.getId(), user.getName(), user.getEmail());

        return response;
    }

}
