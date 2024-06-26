package com.example.Blog_model.config;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.Blog_model.exception.NotFoundEx;
import com.example.Blog_model.user.entity.User;
import com.example.Blog_model.user.respository.UserRepository;
import com.example.Blog_model.user.service.UserAddMoreInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



//khi implements UserDetailsService Spring sẽ tự nhận biết CustomUserDetailsService này thay cho UserDetailsService

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ghi đè phương thức loadUserByUsername của lớp UserDetailsService để load data
    // từ database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("vao day login " + username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundEx("Not found"));


        Set<GrantedAuthority> authorities = new HashSet<>();
        if (user.getRole() != null) {
            authorities.add(new SimpleGrantedAuthority(user.getRole().getNameRole()));
        }
        return new UserAddMoreInfo(user.getUsername(), user.getPassword(),
                authorities, user.getUserId());
    }

}
