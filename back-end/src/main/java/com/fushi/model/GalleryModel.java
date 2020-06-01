package com.fushi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "galleries")

public class GalleryModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private Integer id;

    @Column(name = "imgName",nullable = false)
    @NotEmpty(message = "Image Name is required")
    private String imgName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "images")
    private HouseModel post;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public HouseModel getPost() {
        return post;
    }

    public void setPost(HouseModel post) {
        this.post = post;
    }
}
