package com.example.Blog_model.user.service;

import com.example.Blog_model.exception.DataExists;
import com.example.Blog_model.exception.NotFoundEx;
import com.example.Blog_model.jwt.JwtProvider;
import com.example.Blog_model.role.entity.Role;
import com.example.Blog_model.role.respository.RoleRespository;
import com.example.Blog_model.user.dto.UserInfoDTO;
import com.example.Blog_model.user.dto.UserLoginDTO;
import com.example.Blog_model.user.dto.UserRegisterDTO;
import com.example.Blog_model.user.entity.User;
import com.example.Blog_model.user.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserInterface {
    private final UserRepository userRepository;
    private final RoleRespository roleRespository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserImpl(UserRepository userRepository,
                    RoleRespository roleRespository,
                    PasswordEncoder passwordEncoder,
                    JwtProvider jwtProvider,
                    AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRespository = roleRespository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.authenticationManager = authenticationManager;
    }





    @Override
    public UserLoginDTO loginUser(UserLoginDTO userData) {

        String userName = userData.getUsername();
        Optional<User> optionalUser = userRepository.findByUsername(userName);
        User userDetail = optionalUser.orElseThrow(() -> new NotFoundEx("Username or password is wrong"));


        System.out.println(111234);
        //get body from request to set into authentication in Spring

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                userData.getUsername(), userData.getPassword());
        System.out.println(usernamePasswordAuthenticationToken);

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        System.out.println(11111);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(77777);
        String token = jwtProvider.generateToken(authentication);
        System.out.println(token);
        return new UserLoginDTO(userDetail.getUsername(), token);


    }

    @Override
    public UserInfoDTO getInfo(UserInfoDTO userInfoDTO) {

        //get object current user after login
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserAddMoreInfo userAddMoreInfo = (UserAddMoreInfo) (authentication.getPrincipal()) ;
        System.out.println("idUser::: " + userAddMoreInfo.getId());
        UserInfoDTO userInfo = new UserInfoDTO();
        userInfo.setNameUser(authentication.getName());
        userInfo.setNameRoles( authentication.getAuthorities());
        return userInfo;
    }

    @Override
    public UserRegisterDTO createUser(UserRegisterDTO userData) {
        //check exists username
        if (userRepository.existsByUsername(userData.getUsername())) {
            throw new DataExists("Username already exits in database");
        }
        User user = new User();
        Role roleForNewUser;
        //get Role from data
        if(userData.getRoleName().equals("admin")) {
            roleForNewUser = roleRespository.findByNameRole("admin");
        }
        else {
            roleForNewUser = roleRespository.findByNameRole("user");
        }

        user.setPassword(passwordEncoder.encode(userData.getPassword())); //encode to protect in database
        user.setRole(roleForNewUser);
        user.setEmail(userData.getEmail());
        user.setUsername(userData.getUsername());

        userRepository.save(user);
        //if role is not admin, return user as role
        userData.setUsername(user.getUsername());
        return userData;
    }

}
