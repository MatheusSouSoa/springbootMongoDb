package com.sysmap.demo.service.follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmap.demo.data.FollowRepository;
import com.sysmap.demo.entities.Follower;
import com.sysmap.demo.entities.Following;
import com.sysmap.demo.entities.User;

@Service
public class FollowService implements IFollowService {
    
    @Autowired
    private FollowRepository _followRepository;

    public FindUserResponse findUserByEmail(String email) {

        var user = _followRepository.findUserByEmail(email).get();
        var response = new FindUserResponse(user.getId(), user.getName(), user.getEmail());
        return response;

    }

    public String createFollowed(String email, CreateFollowRequest request){
        var follower = new Follower(request.id, request.name, request.email, request.profilePicture);

        User user = _followRepository.findUserByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        user.getFollowers().add(follower);
        _followRepository.save(user);

        var following = new CreateFollowRequest();
        following.id = user.getId();
        following.name = user.getName();
        following.email = user.getEmail();
        following.profilePicture = user.getProfilePicture();

        createFollowing(request.email, following);

        return user.getId() + " agora é seguido por " + request.getId();
    }

    public void createFollowing(String email, CreateFollowRequest request) {
        var following = new Following(request.id, request.name, request.email, request.profilePicture);

        User user = _followRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        user.getFollowing().add(following);
        _followRepository.save(user);

    }
}
