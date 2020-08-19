package com.example.first.domain;


import javax.persistence.*;

//ORM => Object와 RDB의 Mapping
//@Entity => JPA가 관리하는 Entity
@Entity
public class Member {
    //@ID => PK
    //@GeneratedValue => 주키의 값을 위한 자동 생성전략
    //IDENTITY: DB의 IDENTITY 칼럼 이용, SEQUENCE: DB의 SEQUENCE 칼럼 이용
    //TABLE: 유일성 보장된 데이터 베이스의 테이블 이용
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
