package com.example.board.dto;

import com.example.board.vo.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //기본 생성자 생성
public class BoardDto {
    private String title;
    private String content;

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
