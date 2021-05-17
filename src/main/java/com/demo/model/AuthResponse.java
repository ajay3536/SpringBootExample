package com.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class AuthResponse implements Serializable {

    private final String jwtToken;

    public AuthResponse(String jwtToken){
        this.jwtToken=jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

}
