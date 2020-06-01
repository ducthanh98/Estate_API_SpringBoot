package com.fushi.dto.house;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SearchDTO {
    private String title;

    private String location;


    @NotNull(message = "Bedrooms is required")
    private Integer bedroom;

    @NotNull(message = "Bathrooms is required")
    private Integer bathroom;

    @NotNull(message = "Max Area is required")
    private Float maxArea;

    @NotNull(message = "Min Area is required")
    private Float minArea;


    @NotNull(message = "Min Price is required")
    private Float minPrice;


    @NotNull(message = "Max Price is required")
    private Float maxPrice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getBedroom() {
        return bedroom;
    }

    public void setBedroom(Integer bedrooms) {
        this.bedroom = bedrooms;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public Float getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(Float maxArea) {
        this.maxArea = maxArea;
    }

    public Float getMinArea() {
        return minArea;
    }

    public void setMinArea(Float minArea) {
        this.minArea = minArea;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }
}
