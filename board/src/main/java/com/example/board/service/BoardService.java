package com.example.board.service;

import com.example.board.domain.Board;
import com.example.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class BoardService {

    private BoardRepository boardRepository;

//    public BoardService(BoardRepository boardRepository) {
//        this.boardRepository = boardRepository;
//    }

    public List<Board> getAllList() {
        return boardRepository.findAll();
    }

    public void createBoard(Board board){
        boardRepository.save(board);
    }

    public Board getDetail(Long id){
        return boardRepository.findById(id).get();
    }

    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }


}
