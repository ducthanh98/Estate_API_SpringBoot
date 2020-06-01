package com.fushi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "reportTypes")
public class ReportTypeModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "id")
    private Integer id;

    @Column(name = "reportContent",nullable = false)
    @NotEmpty(message = "Report Content is required")
    private String reportContent;

    @OneToMany(mappedBy = "reportType")
    @JsonBackReference
    private List<ReportModel> reports;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public List<ReportModel> getReports() {
        return reports;
    }

    public void setReports(List<ReportModel> reports) {
        this.reports = reports;
    }
}
