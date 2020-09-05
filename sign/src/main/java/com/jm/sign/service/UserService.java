package com.jm.sign.service;

import com.jm.sign.config.JwtProvider;
import com.jm.sign.dto.JoinDto;
import com.jm.sign.dto.LoginDto;
import com.jm.sign.dto.TokenDto;
import com.jm.sign.repository.UserRepository;
import com.jm.sign.vo.DefaultRes;
import com.jm.sign.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public DefaultRes join(JoinDto joinDto) {
        User newUser = User.builder()
                .name(joinDto.getName())
                .email(joinDto.getEmail())
                .password(passwordEncoder.encode(joinDto.getPassword()))
                .roles(Collections.singletonList("ROLE_USER")) //"ROLE_USER"라는 한개의 요소를 가지는 리스트, ROLE_* 규칙임
                .phone(joinDto.getPhone())
                .sosial(false)
                .build();
        try {
            User savedUser = userRepository.save(newUser);
            return new DefaultRes(200, "CREATE USER SUCCESS", savedUser);
        } catch (Exception e) {
            e.printStackTrace();
            return new DefaultRes(600, "DB ERROR");
        }
    }


    public DefaultRes login(LoginDto loginDto) {
        try {
            //이메일로 DB에 저장된 유저 찾기
            Optional<User> findUser = userRepository.findByEmail(loginDto.getEmail());
            if (findUser.isPresent()) {
                User user = findUser.get();
                if(!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
                    return new DefaultRes(401, "WRONG PASSWORD");
                }
                return new DefaultRes(200, "LOGIN SUCCESS", user);
            } else {
                return new DefaultRes(402, "CANNOT FIND USER");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DefaultRes(600, "DB ERROR");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        return userRepository.findById(Long.parseLong(uid))
                .orElseThrow(() -> new UsernameNotFoundException("CANNOT FIND USER"));

    }


}
