package com.demo.controllers;

import com.demo.model.AuthReqModel;
import com.demo.model.AuthResponse;
import com.demo.securityconfig.JwtTokenGenUtils;
import com.demo.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtTokenGenUtils jwtTokenGenUtils;

    @GetMapping("hello")
    public String fetchHelloDetails(){
        return " Hello Called....";
    }

    @PostMapping("authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthReqModel authReqModel) throws Exception {

          System.out.println("" +authReqModel.getPassword());
            try {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authReqModel.getUsername(), authReqModel.getPassword())
                );

            }
            catch (Exception e)
            {
               throw new Exception("Incorect username and password",e);
            }

            final UserDetails userDetails=myUserDetailsService.loadUserByUsername(authReqModel.getUsername());

            final String jwtToken= jwtTokenGenUtils.generateToken(userDetails);

            return ResponseEntity.ok(new AuthResponse(jwtToken));
    }
}
