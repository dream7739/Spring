package com.example.board.dto;

import com.example.board.vo.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {
    private String name;
    private String email;
    private String passwd;

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .email(email)
                .passwd(passwd)
                .build();

    }
}
