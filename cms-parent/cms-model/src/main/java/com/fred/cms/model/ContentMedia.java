package com.fred.cms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "content_media")
public class ContentMedia implements Serializable {

    private static final long serialVersionUID = -2695255214033043601L;

    @EmbeddedId
    private ContentMediaId contentMediaId;

    @Column(name = "is_cover", nullable = false)
    private Boolean isCover;

    public ContentMedia() {
    }

    public ContentMediaId getContentMediaId() {
        return contentMediaId;
    }

    public void setContentMediaId(ContentMediaId contentMediaId) {
        this.contentMediaId = contentMediaId;
    }

    public Boolean getIsCover() {
        return isCover;
    }

    public void setIsCover(Boolean isCover) {
        this.isCover = isCover;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contentMediaId == null) ? 0 : contentMediaId.hashCode());
        result = prime * result + ((isCover == null) ? 0 : isCover.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ContentMedia other = (ContentMedia) obj;
        if (contentMediaId == null) {
            if (other.contentMediaId != null)
                return false;
        } else if (!contentMediaId.equals(other.contentMediaId))
            return false;
        if (isCover == null) {
            if (other.isCover != null)
                return false;
        } else if (!isCover.equals(other.isCover))
            return false;
        return true;
    }

}