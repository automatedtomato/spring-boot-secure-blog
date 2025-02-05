package com.automatedtomato.blog.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.automatedtomato.blog.domain.entities.User;
import com.automatedtomato.blog.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BlogUserDetailsService implements UserDetailsService {
    
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new BlogUserDetails(user);
    }

}
