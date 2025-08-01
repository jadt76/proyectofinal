package com.shaddai.proyectofinal.service.impl;

import com.shaddai.proyectofinal.dto.request.UserRequest;
import com.shaddai.proyectofinal.dto.response.UserResponse;
import com.shaddai.proyectofinal.model.Cart;
import com.shaddai.proyectofinal.model.User;
import com.shaddai.proyectofinal.repository.UserRepository;
import com.shaddai.proyectofinal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public UserResponse registerUser(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("User Role not found."));
        user.setRoles(Set.of(userRole));

        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);

        User savedUser = userRepository.save(user);
        return  modelMapper.map(savedUser, UserResponse.class);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
}
