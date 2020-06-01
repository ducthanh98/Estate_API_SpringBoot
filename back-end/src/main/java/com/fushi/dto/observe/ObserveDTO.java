package com.fushi.dto.observe;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ObserveDTO {
    @NotEmpty(message = "Email is required")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
