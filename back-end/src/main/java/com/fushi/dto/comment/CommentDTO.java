package com.fushi.dto.comment;

import com.fushi.model.UserModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CommentDTO {
    @NotEmpty(message = "Comment is required")
    private String comment;

    @NotNull(message = "Post ID is required")
    private Integer postID;

    @NotNull(message = "User ID is required")
    private Integer userID;

    public String getComment() {
        return comment;
    }

    public void setComment(String comments) {
        this.comment = comments;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
