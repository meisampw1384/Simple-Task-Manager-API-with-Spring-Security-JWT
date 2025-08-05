package com.interview.taskmanager.task_manager.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.interview.taskmanager.task_manager.config.SecurityUser;
import com.interview.taskmanager.task_manager.dto.AuthenticateRequest;
import com.interview.taskmanager.task_manager.dto.AuthenticateResponse;
import com.interview.taskmanager.task_manager.dto.RegisterRequest;
import com.interview.taskmanager.task_manager.repository.UserRepository;
import com.interview.taskmanager.task_manager.model.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticateResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        userRepository.save(user);

        var userDetails= new SecurityUser(user);
        String jwtToken = jwtService.generateToken(userDetails);

        return AuthenticateResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticateResponse authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var userDetails = new SecurityUser(user);
        String jwtToken = jwtService.generateToken(userDetails);

        return AuthenticateResponse.builder()
                .token(jwtToken)
                .build();
    }
}
