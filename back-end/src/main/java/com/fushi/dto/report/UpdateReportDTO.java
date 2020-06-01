package com.fushi.dto.report;

import javax.validation.constraints.NotNull;

public class UpdateReportDTO {
    @NotNull(message = "Post ID is required")
    private Integer postId;

    @NotNull(message = "Status is required")
    private Integer status;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
