package site.tellmetodo.todoapp.global.auth.security;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import site.tellmetodo.todoapp.domain.user.entity.User;

import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Getter
public class UserDetailsImpl implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정 만료 여부
    @Override
    public boolean isAccountNonExpired() {
        // INACTIVE 유저 판단(탈퇴했는지)
        return true;
    }

    // 계정 잠김 여부
    @Override
    public boolean isAccountNonLocked() {
        // SUSPENDED 유저 판단
        return true;
    }

    // 비밀번호 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 사용자 활성 여부
    @Override
    public boolean isEnabled() {
        return true;
    }
}
