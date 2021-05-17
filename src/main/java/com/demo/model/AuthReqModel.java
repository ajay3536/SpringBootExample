package com.demo.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class AuthReqModel  implements Serializable {

    private String username;
    private String password;

    //need default constructor for JSON Parsing
    public AuthReqModel()
    {
        super();
    }

    public AuthReqModel(String username,String password){
        this.username=username;
        this.password=password;
    }
}

