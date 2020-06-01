package com.fushi.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
@Table(name = "accounts")
public class UserModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",nullable = false)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(name = "email",nullable = false)
    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;

    @Column(name = "password",nullable = false)
    @NotEmpty(message = "Password is required")
    private String password;

    @Column(name = "avatar")
    private String avatar="avatar.jpg";

    @Column(name = "phone")
    private String phone;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "skype")
    private String skype;

    @Column(name = "role")
    private Integer role=3;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "subcribe")
    private Boolean subcribe;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ReportModel> reports;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<HouseModel> houses;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<CommentModel> comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getSubcribe() {
        return subcribe;
    }

    public void setSubcribe(Boolean subcribe) {
        this.subcribe = subcribe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ReportModel> getReports() {
        return reports;
    }

    public void setReports(List<ReportModel> reports) {
        this.reports = reports;
    }

    public List<HouseModel> getHouses() {
        return houses;
    }

    public void setHouses(List<HouseModel> houses) {
        this.houses = houses;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }
}
