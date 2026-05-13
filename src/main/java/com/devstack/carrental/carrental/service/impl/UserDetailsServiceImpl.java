package com.devstack.carrental.carrental.service.impl;

import com.devstack.carrental.carrental.entity.User;
import com.devstack.carrental.carrental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository systemUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return systemUserRepo.findSystemUserByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found " + username));
    }
}
