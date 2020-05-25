package com.fushi.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "reports")
public class ReportModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private Integer id;

    @CreatedDate
    private Date createdDate;

    @Column(name = "status",nullable = false)
    @NotEmpty(message = "Status is required")
    private Integer status;  // 0 chua xu li | 1 bao cao vi pham chinh xac | 2 bao cao sai

    @ManyToOne
    private ReportTypeModel reportType;

    @ManyToOne
    private UserModel author;

    @ManyToOne
    private HouseModel house;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ReportTypeModel getReportType() {
        return reportType;
    }

    public void setReportType(ReportTypeModel reportType) {
        this.reportType = reportType;
    }

    public UserModel getAuthor() {
        return author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }
}
