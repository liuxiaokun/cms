/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:58:13 AM
 */
package com.fred.cms.request;

public class ContentListRequest extends PaginationRequest {

    private static final long serialVersionUID = 4419771638459093878L;

    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
