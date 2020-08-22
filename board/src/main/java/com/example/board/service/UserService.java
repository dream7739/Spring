package com.example.board.service;


import com.example.board.repository.UserRepository;
import com.example.board.vo.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository memberRepository;

    public void createMember(User member){
        memberRepository.save(member);
    }

    public List<User> getUserList(){
        return memberRepository.findAll();
    }

}
