package com.example.board.controller;

import com.example.board.domain.Board;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 메인 게시글 조회
     */
    @GetMapping("/board/list")
    public String mainBoardList(Model model){
        List<Board> boardList = boardService.getAllList();
        model.addAttribute("list", boardList);
        return "board/list";
    }

    /**
     * 게시글 작성 화면
     */
    @GetMapping("/board/create")
    public String createBoardMain(){
        return "/board/create";
    }


    /**
     * 게시글 작성 폼 제출
     */
    @PostMapping("/board/create")
    public String createBoard(Board board){
        boardService.createBoard(board);
        return "redirect:/board/list";
    }

    /**
     * 게시글 상세 보기
     */
    @GetMapping("/board/detail/{id}")
    public String boardDetail(@PathVariable("id") Long id, Model model){
        Board board = boardService.getDetail(id);
        model.addAttribute("board", board);
        return "board/detail";
    }

    /**
     * 게시글 삭제
     */
    @GetMapping("board/remove/{id}")
    public String deleteBoard(@PathVariable("id") Long id){
        boardService.deleteBoard(id);
        return "redirect:/board/list";
    }
}
