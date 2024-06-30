package com.example.Blog_model.jwt;

import com.example.Blog_model.config.CustomUserDetailsService;
import com.example.Blog_model.exception.JwtExeption;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Qualifier("handlerExceptionResolver") // this annotation allow throw exception to catch in global exception
    @Autowired
    private HandlerExceptionResolver resolver;

    JwtProvider jwtProvider;
    CustomUserDetailsService userDetailsService;

    @Autowired
    public JwtFilter(JwtProvider jwtProvider, CustomUserDetailsService userDetailsService) {
        this.jwtProvider = jwtProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = jwtProvider.getTokenFromRequestHeader(request);
            if(jwtProvider.verifyToken(token)) {
                String usernameGetFromToken = jwtProvider.getPayloadfromtoken(token);

                //load userDetail from database by loadUserByUsername
                UserDetails userDetail = userDetailsService.loadUserByUsername(usernameGetFromToken);

                // set userDetail to UsernamePasswordAuthenticationToken
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetail, null, userDetail.getAuthorities());

                //add more secure
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //set to SecurityContextHolder to accept the permission access in app
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            else {
                //with request login, register, swagger don't have token..
                String reqPath = request.getRequestURI();
                List<String> urlAcceptNotToken = Arrays.asList("/auth/register", "/auth/login", "/swagger-ui", "/v3/api-docs");
                  boolean isUrlAccepted =   urlAcceptNotToken.stream().anyMatch(reqPath::contains);
                  if(!isUrlAccepted) {
                      throw new JwtExeption();
                  }

            }
            //continue to handle other filter
            filterChain.doFilter(request, response);
        }
        catch (Exception e) {
            System.out.println("Spring Security Filter Chain Exception:" +
                    e.getMessage());
            resolver.resolveException(request, response, null, e);
        }

    }
}
