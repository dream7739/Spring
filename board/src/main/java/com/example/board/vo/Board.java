package com.example.board.vo;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;

//@Entity: 테이블과 링크될 클래스를 나타냄
//@NoArgsConstructor = 기본생성자 자동 추가
@NoArgsConstructor
@Getter
@Entity
public class Board extends BaseTimeEntity {
    //@Id : PK
    //@GeneratedValue: PK 생성 규약
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column: 테이블의 Column, 특정 조건을 걸기 위해 사용
    @Column(length = 500, nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;


    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
