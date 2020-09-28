package com.login.login.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBUserRequestAddDto {
    private String name;
    private String password;
    private String email;
}
