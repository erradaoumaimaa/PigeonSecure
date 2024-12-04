package com.oumaima.pigeonSecure.service.user.Impl;

import com. oumaima. pigeonSecure. entity. User;
import com.oumaima.pigeonSecure.exception.user.UserNotFoundException;
import com.oumaima.pigeonSecure.repository.UserRepository;
import com.oumaima.pigeonSecure.security.UserDetailModel;
import com.oumaima.pigeonSecure.service.user.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));

        return new UserDetailModel(user);
    }

}

