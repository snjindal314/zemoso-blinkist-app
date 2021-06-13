package com.zemoso.training.security;

import com.zemoso.training.entity.User;
import com.zemoso.training.exception.ResourceNotFoundException;
import com.zemoso.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        return user.map(UserDetailsImpl::new).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
