package com.example.board.repository;

import com.example.board.vo.User;

import java.util.List;


public interface UserRepository {
    User save(User member);
    List<User> findAll();
}
