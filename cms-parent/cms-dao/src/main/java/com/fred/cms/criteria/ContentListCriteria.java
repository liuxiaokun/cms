/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:55:34 AM
 */
package com.fred.cms.criteria;

public class ContentListCriteria extends PaginationCriteria {

    private static final long serialVersionUID = 7329981590092185858L;

    private Integer userId;

    private Integer categoryId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}
