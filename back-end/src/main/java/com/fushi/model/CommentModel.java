package com.fushi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "comments")
public class CommentModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private Integer id;

    @Column(name = "comment",nullable = false)
    @NotEmpty(message = "Comment is required")
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "comments")
    private HouseModel post;

    @ManyToOne
    @JsonManagedReference
    private UserModel user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comments;
    }

    public void setComment(String comment) {
        this.comments = comment;
    }

    public HouseModel getPost() {
        return post;
    }

    public void setPost(HouseModel post) {
        this.post = post;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
