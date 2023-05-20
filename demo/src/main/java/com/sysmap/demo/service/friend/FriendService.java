package com.sysmap.demo.service.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmap.demo.data.FriendRepository;
import com.sysmap.demo.entities.Friend;
import com.sysmap.demo.entities.User;

@Service
public class FriendService implements IFriendService {

    @Autowired
    private FriendRepository _friendRepository;

    public FindUserResponse findUserByEmail (String email) {

        var user = _friendRepository.findUserByEmail(email).get();
        var response = new FindUserResponse(user.getId(), user.getName(), user.getEmail());
        return response;

    }

    public String createFriend(String email, CreateFriendRequest request) {
        var friend = new Friend(request.id, request.name, request.email, request.profilePicture);

        User user = _friendRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        user.getFriends().add(friend);
        _friendRepository.save(user);

        return user.getId() + " agora é amigo de " + request.getId();
    }
}
