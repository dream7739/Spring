package com.example.board.vo;

//abstract class vs interface
//공통 : 추상 메소드를 구현하도록 강제
//차이1 : 추상클래스는 추상메소드 1개 or abstract 정의, 인터페이스는 모든 메소드가 추상메소드
//차이2 : 존재목적의 차이. 인터페이스는 함수의 구현을 강제해 구현 객체의 같은 동작 보장, 추상메소드는 기능 이용과 확장

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity클래스에 Auditing(생성, 수정시간 자동화) 기능을 포함


//BaseTimeEntity : 모든 Entity의 상위클래스로 Entity의 createdTime, modifiedDate 자동 관리
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createDate;
    //java8이상 LocalDateTime

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
