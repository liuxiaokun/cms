/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:57:41 AM
 */
package com.fred.cms.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fred.cms.constant.EntityType;

@Entity
@Table(name = "media")
public class Media implements Serializable {

    private static final long serialVersionUID = -8415793505326516458L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "media_id", unique = true, nullable = false)
    private Long mediaId;

    @Column(name = "entity_type_id", nullable = false)
    private Integer entityTypeId = EntityType.CONTENT;

    @Column(name = "url", nullable = false)
    private String url;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

    public Media() {
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(final Long mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getEntityTypeId() {
        return entityTypeId;
    }

    public void setEntityTypeId(final Integer entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(final Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(final Date updated) {
        this.updated = updated;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((entityTypeId == null) ? 0 : entityTypeId.hashCode());
        result = prime * result + ((mediaId == null) ? 0 : mediaId.hashCode());
        result = prime * result + ((updated == null) ? 0 : updated.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
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
        Media other = (Media) obj;
        if (created == null) {
            if (other.created != null)
                return false;
        } else if (!created.equals(other.created))
            return false;
        if (entityTypeId == null) {
            if (other.entityTypeId != null)
                return false;
        } else if (!entityTypeId.equals(other.entityTypeId))
            return false;
        if (mediaId == null) {
            if (other.mediaId != null)
                return false;
        } else if (!mediaId.equals(other.mediaId))
            return false;
        if (updated == null) {
            if (other.updated != null)
                return false;
        } else if (!updated.equals(other.updated))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }
}