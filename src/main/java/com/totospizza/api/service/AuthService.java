package com.totospizza.api.service;

import com.totospizza.api.dto.request.LoginRequest;
import com.totospizza.api.dto.request.RegisterRequest;
import com.totospizza.api.dto.response.AuthResponse;


public interface AuthService {
    public AuthResponse login(LoginRequest request);

    public AuthResponse signup(RegisterRequest request);
}
