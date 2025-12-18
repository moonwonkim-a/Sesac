package com.ohgiraffers.jwtsecurity.auth.model;

import com.ohgiraffers.jwtsecurity.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetailsUser implements UserDetails {

    private final User user;

    public DetailsUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }


    /**
     * 사용자의 권한 목록을 반환하는 메소드
     * - 권한은 "ROLE_" 접두사가 붙거나, 혹은 그냥 문자열(예: "USER", "ADMIN")로 관리됩니다.
     * - SimpleGrantedAuthority 객체로 감싸서 반환해야 합니다.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // UserRole Enum의 이름을 문자열로 가져와서 권한으로 등록
        // 예: UserRole.USER -> "USER"
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getUserPass();
    }

    @Override
    public String getUsername() {
        return user.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화 여부 (true: 활성화됨)
    @Override
    public boolean isEnabled() {
        // DB의 state 값이 'Y'인 경우에만 로그인을 허용
        // 'N'(휴면/탈퇴)인 경우 false를 반환하여 로그인을 막는다
        return "Y".equals(user.getState());
    }
}
