package com.example.board.domain;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity: 테이블과 링크될 클래스를 나타냄
//@NoArgsConstructor = 기본생성자 자동 추가, 생성자 protected Board()와 동일
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
