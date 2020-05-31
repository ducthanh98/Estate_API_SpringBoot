package com.fushi.dto.auth.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class ChangePassDTO {
    @Column(name = "name",nullable = false)
    @NotEmpty(message = "Old Password is required")
    private String oldPass;

    @Column(name = "name",nullable = false)
    @NotEmpty(message = "New Password is required")
    private String password;

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
