package com.fushi.dto.house;


import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class HouseDTO {
    private Integer id;

    @NotEmpty(message = "Title is required")
    private String title;

    @NotEmpty(message = "Location is required")
    private String location;

    @NotNull(message = "Lat is required")
    private Float lat;


    @NotNull(message = "Lng is required")
    private Float lng;


    @NotNull(message = "Bedrooms is required")
    private Integer bedrooms;


    @NotNull(message = "Bathrooms is required")
    private Integer bathrooms;

    @NotNull(message = "Area is required")
    private Float area;

    @NotNull(message = "Price is required")
    private Float price;

    @NotEmpty(message = "Description is required")
    private String description;

    private Integer[] amentities;

    private Integer userId;

    private MultipartFile[] files;


//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
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

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer[] getAmentities() {
        return amentities;
    }

    public void setAmentities(Integer[] amentities) {
        this.amentities = amentities;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
