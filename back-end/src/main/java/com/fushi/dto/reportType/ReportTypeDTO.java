package com.fushi.dto.reportType;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class ReportTypeDTO {
    @NotEmpty(message = "Report Content is required")
    private String reportContent;

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}
