package com.example.board.dto;

import com.example.board.vo.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private String passwd;

    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .passwd(passwd)
                .build();

    }
}
