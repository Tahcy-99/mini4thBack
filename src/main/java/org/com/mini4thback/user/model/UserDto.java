package org.com.mini4thback.user.model;

import lombok.Getter;

public class UserDto {

    @Getter
    public static class Signin{
        private String email;
        private String name;
        private String password;

        public User toEntity(){
            return User.builder()
                    .email(this.email)
                    .name(this.name)
                    .password(this.password)
                    .enable(false)
                    .role("ROLE_USER")
                    .build();
        }
    }
}
