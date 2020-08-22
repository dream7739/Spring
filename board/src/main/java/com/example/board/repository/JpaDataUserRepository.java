package com.example.board.repository;

import com.example.board.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDataUserRepository extends JpaRepository<User, Long>, UserRepository {
}
