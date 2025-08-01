package com.shaddai.proyectofinal.service;

import com.shaddai.proyectofinal.dto.request.UserRequest;
import com.shaddai.proyectofinal.dto.response.UserResponse;
import com.shaddai.proyectofinal.model.User;

public class UserService {
    UserResponse registerUser(UserRequest userRequest);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User getCurrentUser();
}
