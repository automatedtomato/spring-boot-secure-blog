package com.automatedtomato.blog.services;

import java.util.UUID;

import com.automatedtomato.blog.domain.entities.User;


public interface UserService {
    User getUserById(UUID id);
}
