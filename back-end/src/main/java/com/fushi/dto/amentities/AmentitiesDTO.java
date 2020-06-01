package com.fushi.dto.amentities;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class AmentitiesDTO {
    @Column(name = "name",nullable = false)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(name = "icon",nullable = false)
    @NotEmpty(message = "Icon is required")
    private String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
