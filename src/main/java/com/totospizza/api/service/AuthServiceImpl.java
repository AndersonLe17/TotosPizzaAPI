package com.totospizza.api.service;

import com.totospizza.api.dto.request.LoginRequest;
import com.totospizza.api.dto.request.RegisterRequest;
import com.totospizza.api.dto.response.AuthResponse;
import com.totospizza.api.entity.Client;
import com.totospizza.api.entity.Person;
import com.totospizza.api.entity.User;
import com.totospizza.api.entity.enums.Role;
import com.totospizza.api.entity.enums.UserState;
import com.totospizza.api.repository.ClientRepository;
import com.totospizza.api.repository.PersonRepository;
import com.totospizza.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final ClientRepository clientRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        String token =jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponse signup(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_CLIENT)
                .state(UserState.ACTIVE)
                .build();
        user = userRepository.save(user);

        Person person = Person.builder()
                .user(user)
                .name(request.getPerson().getName())
                .lastname(request.getPerson().getLastname())
                .document(request.getPerson().getDocument())
                .documentNumber(request.getPerson().getDocumentNumber())
                .email(request.getPerson().getEmail())
                .phone(request.getPerson().getPhone())
                .birthdate(request.getPerson().getBirthdate())
                .gender(request.getPerson().getGender())
                .build();
        person = personRepository.save(person);

        Client client = Client.builder()
                .person(person)
                .build();

        clientRepository.save(client);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
