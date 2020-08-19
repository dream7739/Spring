package com.example.board.repository;

import com.example.board.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    //모든 게시글 조회
    List<Board> findAll();

    //게시글 작성
    Board save(Board board);

    //게시글 상세
    Optional<Board> findById(Long name);

    //게시글 상세 - 게시글 삭제
    void deleteById(Long id);
}
