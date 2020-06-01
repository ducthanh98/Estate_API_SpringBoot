package com.fushi.dto.report;

import javax.validation.constraints.NotNull;

public class ReportDTO {
    @NotNull(message = "Post ID is required")
    private Integer postID;

    @NotNull(message = "Report Type ID is required")
    private Integer reportTypeID;

    @NotNull(message = "User ID is required")
    private Integer userID;

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public Integer getReportTypeID() {
        return reportTypeID;
    }

    public void setReportTypeID(Integer reportTypeID) {
        this.reportTypeID = reportTypeID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
