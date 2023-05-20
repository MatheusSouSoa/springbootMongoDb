package com.sysmap.demo.service.security;

import java.util.UUID;

public interface IJwtService {

    String generateToken(UUID userId);
    boolean isValidtoken(String token, String userId);

}
