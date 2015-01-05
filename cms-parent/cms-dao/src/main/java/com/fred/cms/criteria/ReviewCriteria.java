package com.fred.cms.criteria;

public class ReviewCriteria extends PaginationCriteria {

    private static final long serialVersionUID = -2814378301638401054L;

    private Integer contentId;

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

}
