package com.jm.sign.dto;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinDto {
    //유저 이메일
    private String email;

    //유저 이름
    private String name;

    //유저 비밀번호
    private String password;

    //유저전화번호
    private String phone;

    //소셜 회원가입인지 확인
    private boolean sosial;

}
