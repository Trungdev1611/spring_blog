package com.example.Blog_model.user.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

//this class I create to alternate
/*
*     return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
                *
                * to  return UserAddMoreInfo(user.getUsername(), user.getPassword(),
                authorities);
                * in customeUserDetailService
* */

@Getter
@Setter
public class UserAddMoreInfo extends User {
    private Long id;

    public UserAddMoreInfo(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }


    public UserAddMoreInfo(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id) {
        super(username, password, authorities);
        this.id = id;
    }

}
