package com.dh.DentalClinicMVC.authentication;

import com.dh.DentalClinicMVC.entity.Role;
import com.dh.DentalClinicMVC.entity.User;
import com.dh.DentalClinicMVC.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private IUserRepository userRepository;

    public AuthenticationResponse register (RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }

    public AuthenticationResponse login (AuthenticationRequest request) {
        return null;
    }

}

