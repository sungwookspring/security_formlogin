package com.login.login.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Long save(DBUserRequestAddDto requestAddDto){
        DBUser new_user = DBUser.builder()
                .name(requestAddDto.getName())
                .password(passwordEncoder.encode(requestAddDto.getPassword()))
                .email(requestAddDto.getEmail())
                .build();

        return userRepository.save(new_user).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("called");

        DBUser findUser = userRepository.findByName(username).orElseThrow();

        log.info("success find: " + findUser.getName());
        return UserDetail.builder()
                .user(findUser)
                .build();
    }
}
