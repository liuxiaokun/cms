package com.fred.cms.vo;

import java.io.Serializable;
import java.util.Date;

public class ReviewListVO implements Serializable {

    private static final long serialVersionUID = -4037413223931961523L;

    private Integer userId;

    private String reviewContent;

    private Date created;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
