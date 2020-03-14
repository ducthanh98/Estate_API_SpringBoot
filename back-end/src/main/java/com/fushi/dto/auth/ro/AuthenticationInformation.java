package com.fushi.dto.auth.ro;

public class AuthenticationInformation {
    private String access_token;
    private UserRO user_info;

    public String getAccess_token() {
        return access_token;
    }

    public AuthenticationInformation setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public UserRO getUser_info() {
        return user_info;
    }

    public AuthenticationInformation setUser_info(UserRO user_info) {
        this.user_info = user_info;
        return this;
    }


}
