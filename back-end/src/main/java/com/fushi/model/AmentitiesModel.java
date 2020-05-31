package com.fushi.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "amentities")
public class AmentitiesModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",nullable = false)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(name = "icon",nullable = false)
    @NotEmpty(message = "Icon is required")
    private String icon;


    @ManyToMany(fetch = FetchType.LAZY)
    private List<HouseModel> houses;


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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<HouseModel> getHouses() {
        return houses;
    }

    public void setHouses(List<HouseModel> houses) {
        this.houses = houses;
    }
}
