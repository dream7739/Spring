package com.example.board.repository;

import com.example.board.vo.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaDataBoardRepository extends JpaRepository<Board, Long>, BoardRepository {

}
