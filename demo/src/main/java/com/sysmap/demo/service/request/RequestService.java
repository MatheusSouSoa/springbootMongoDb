package com.sysmap.demo.service.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmap.demo.data.RequestRepository;
import com.sysmap.demo.entities.Request;
import com.sysmap.demo.entities.User;

@Service
public class RequestService implements IRequestService{
    
    @Autowired
    private RequestRepository _requestRepository;

    public String createRequest(String email, CreateReqRequest request) {

        var req = new Request(request.id, request.name, request.profilePicture);

        User user =  _requestRepository.findUserByEmail(email).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        user.getRequests().add(req);
        _requestRepository.save(user);

        return user.getName()+" recebeu uma nova solicitação de "+ req.getName();
    }

}
