package com.example.demo.Authorized;

import com.example.demo.Auth.User;
import com.example.demo.Auth.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    jwtUtil jwtUtil;
   @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
          String requestToken=request.getHeader("Authorization");
          String email = null;

       String token = null;

          if(request!=null&&requestToken.startsWith("Bearer")){
              token=requestToken.substring(7);
              try {
                  email = this.jwtUtil.getEmailIdFromToken(token);
              } catch (ExpiredJwtException e) {
                  System.out.println("jwt time limit done");
              }
              catch (IllegalArgumentException e){
                  System.out.println("get token");

              }
              catch (MalformedJwtException e){
                  System.out.println("jwt wrong");
              }


          }
          else {
              System.out.println("jwt is wrong entered");
          }
              if(email!=null){
                  User user=userRepository.findOneByEmail(email);
                 if(this.jwtUtil.validateToken(token,user)){

              }
          }


    }
}
