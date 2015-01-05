package com.fred.cms.vo;

import java.io.Serializable;
import java.util.Date;

public class ContentListVO implements Serializable {

    private static final long serialVersionUID = -5623302143260890808L;

    private Integer contentId;

    private String title;

    private String description;

    private Date create;

    private Integer sortOrder;

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}