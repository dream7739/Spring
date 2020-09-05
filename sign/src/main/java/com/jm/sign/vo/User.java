package com.jm.sign.vo;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity //@Entity 어노테이션을 통해 동일 명의 테이블과 매핑
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    //UserDetails: Spring Security에서 사용자 정보를 담는 인터페이스
    //이 인터페이스 구현하면 사용자 정보로 인식하고 인증 작업을 함

    @Id
    @GeneratedValue
    private Long uid;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String phone;

    @Column
    private Boolean sosial;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();


    //계정이 가지고 있는 권한 목록을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new) //모든 요소를 SimpleGrantedAuthority로 변환
                .collect(Collectors.toList());
    }

    //계정 이름 리턴
    @Override
    public String getUsername() {
        return email;
    }

    //계정이 만료되지 않았는지 리턴(true = 만료 안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정이 잠겨있지 않은지 리턴(true = 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    //비밀번호 만료되지 않았는지 리턴(true = 만료 안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정이 사용 가능인지 리턴(true = 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
