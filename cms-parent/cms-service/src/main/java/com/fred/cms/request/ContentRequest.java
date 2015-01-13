/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 13, 2015 6:02:50 PM
 */
package com.fred.cms.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class ContentRequest implements Serializable {

    private static final long serialVersionUID = 6294958493764651335L;

    @NotNull
    private Integer categoryId;

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private String content;

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
