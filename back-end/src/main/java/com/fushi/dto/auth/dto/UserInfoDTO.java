package com.fushi.dto.auth.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserInfoDTO {
    @Column(name = "name",nullable = false)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "skype")
    private String skype;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }
}
