package com.example.project.service;

import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import com.example.project.token.Token;
import com.example.project.token.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;


    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
//    public Optional<User> findUserByToken(String token) {
//        Integer user_id =  tokenRepository.findUserIdByToken(token);
//        System.out.println("userservice - " + user_id);
//        System.out.println("asdasd " + userRepository.findByUserId(user_id));

//        return userRepository.findByUserId(user_id);
//    }
}
