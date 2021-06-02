package com.manning.readinglist;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Reader implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    private String username;
    private String fullname;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"));
    }

    @Override
    public boolean isAccountNonExpired() { // 계정이 만료되지 않음
        return false;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정이 잠겨있음
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 자격이 유효함
        return false;
    }

    @Override
    public boolean isEnabled() { // 계정이 활성화되어 있음
        return false;
    }
}
