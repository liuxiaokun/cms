/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:57:35 AM
 */
package com.fred.cms.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContentMediaId implements java.io.Serializable {

    private static final long serialVersionUID = -7524146461827598567L;

    @Column(name = "content_id", nullable = false)
    private Integer contentId;

    @Column(name = "media_id", nullable = false)
    private Long mediaId;

    public ContentMediaId() {
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contentId == null) ? 0 : contentId.hashCode());
        result = prime * result + ((mediaId == null) ? 0 : mediaId.hashCode());
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
        ContentMediaId other = (ContentMediaId) obj;
        if (contentId == null) {
            if (other.contentId != null)
                return false;
        } else if (!contentId.equals(other.contentId))
            return false;
        if (mediaId == null) {
            if (other.mediaId != null)
                return false;
        } else if (!mediaId.equals(other.mediaId))
            return false;
        return true;
    }

}