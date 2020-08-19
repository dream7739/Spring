package com.example.board.repository;

import com.example.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaDataBoardRepository extends JpaRepository<Board, Long>, BoardRepository {

}
