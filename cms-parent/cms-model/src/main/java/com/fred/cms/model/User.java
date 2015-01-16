/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:57:50 AM
 */
package com.fred.cms.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
@NamedQueries({ @NamedQuery(name = "User.getByEmail", query = "FROM User WHERE email = :email AND isActive = true") })
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 6718859190782978249L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", unique = true)
    private Integer userId;

    @Column(name = "nickname", unique = true, nullable = false)
    private String nickname;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "mobile", unique = true, length = 11)
    private String mobile;

    @Column(name = "password", nullable = false, length = 32)
    private String password;

    @Column(name = "salt", nullable = false, length = 6)
    private String salt;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = Boolean.TRUE;

    @Column(name = "is_email_verified", nullable = false)
    private Boolean isEmailVerified = false;

    @Column(name = "is_mobile_verified", nullable = false)
    private Boolean isMobileVerified = false;

    @Column(name = "client_ip", nullable = false)
    private Long clientIp;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login", nullable = false)
    private Date lastLogin;

    @Column(name = "last_ip", nullable = false)
    private Long lastIp = 0L;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsEmailVerified() {
        return isEmailVerified;
    }

    public void setIsEmailVerified(Boolean isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    public Boolean getIsMobileVerified() {
        return isMobileVerified;
    }

    public void setIsMobileVerified(Boolean isMobileVerified) {
        this.isMobileVerified = isMobileVerified;
    }

    public Long getClientIp() {
        return clientIp;
    }

    public void setClientIp(Long clientIp) {
        this.clientIp = clientIp;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Long getLastIp() {
        return lastIp;
    }

    public void setLastIp(Long lastIp) {
        this.lastIp = lastIp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
        result = prime * result + ((clientIp == null) ? 0 : clientIp.hashCode());
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((isEmailVerified == null) ? 0 : isEmailVerified.hashCode());
        result = prime * result + ((isMobileVerified == null) ? 0 : isMobileVerified.hashCode());
        result = prime * result + ((lastIp == null) ? 0 : lastIp.hashCode());
        result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
        result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
        result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((salt == null) ? 0 : salt.hashCode());
        result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
        result = prime * result + ((updated == null) ? 0 : updated.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
        User other = (User) obj;
        if (avatar == null) {
            if (other.avatar != null)
                return false;
        } else if (!avatar.equals(other.avatar))
            return false;
        if (clientIp == null) {
            if (other.clientIp != null)
                return false;
        } else if (!clientIp.equals(other.clientIp))
            return false;
        if (created == null) {
            if (other.created != null)
                return false;
        } else if (!created.equals(other.created))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (isEmailVerified == null) {
            if (other.isEmailVerified != null)
                return false;
        } else if (!isEmailVerified.equals(other.isEmailVerified))
            return false;
        if (isMobileVerified == null) {
            if (other.isMobileVerified != null)
                return false;
        } else if (!isMobileVerified.equals(other.isMobileVerified))
            return false;
        if (lastIp == null) {
            if (other.lastIp != null)
                return false;
        } else if (!lastIp.equals(other.lastIp))
            return false;
        if (lastLogin == null) {
            if (other.lastLogin != null)
                return false;
        } else if (!lastLogin.equals(other.lastLogin))
            return false;
        if (mobile == null) {
            if (other.mobile != null)
                return false;
        } else if (!mobile.equals(other.mobile))
            return false;
        if (nickname == null) {
            if (other.nickname != null)
                return false;
        } else if (!nickname.equals(other.nickname))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (salt == null) {
            if (other.salt != null)
                return false;
        } else if (!salt.equals(other.salt))
            return false;
        if (isActive == null) {
            if (other.isActive != null)
                return false;
        } else if (!isActive.equals(other.isActive))
            return false;
        if (updated == null) {
            if (other.updated != null)
                return false;
        } else if (!updated.equals(other.updated))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }
}