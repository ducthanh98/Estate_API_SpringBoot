package com.fushi.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "houses")
public class HouseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private Integer id;

    @Column(name = "title",nullable = false)
    @NotEmpty(message = "Title is required")
    private String title;

    @Column(name = "location",nullable = false)
    @NotEmpty(message = "Location is required")
    private String location;

    @Column(name = "lat",nullable = false)
    @NotNull(message = "Lat is required")
    private Float lat;


    @Column(name = "lng",nullable = false)
    @NotNull(message = "Lng is required")
    private Float lng;


    @Column(name = "bedrooms",nullable = false)
    @NotNull(message = "Bedrooms is required")
    private Integer bedrooms;


    @Column(name = "bathrooms",nullable = false)
    @NotNull(message = "Bathrooms is required")
    private Integer bathrooms;

    private Boolean status = false;

    @Column(name = "area",nullable = false)
    @NotNull(message = "Area is required")
    private Float area;

    @Column(name = "price",nullable = false)
    @NotNull(message = "Price is required")
    private Float price;

    @Column(name = "description",nullable = false)
    @NotEmpty(message = "Description is required")
    private String description;

    @CreatedDate
    private Date createdDate;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "houses")
    private List<AmentitiesModel> amentities;


    @ManyToOne
    private UserModel author;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<CommentModel> comments;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<GalleryModel> images;

    @OneToMany(mappedBy = "house",cascade = CascadeType.ALL)
    private List<ReportModel> reports;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<AmentitiesModel> getAmentities() {
        return amentities;
    }

    public void setAmentities(List<AmentitiesModel> amentities) {
        this.amentities = amentities;
    }

    public UserModel getAuthor() {
        return author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public List<GalleryModel> getImages() {
        return images;
    }

    public void setImages(List<GalleryModel> images) {
        this.images = images;
    }

    public List<ReportModel> getReports() {
        return reports;
    }

    public void setReports(List<ReportModel> reports) {
        this.reports = reports;
    }
}
