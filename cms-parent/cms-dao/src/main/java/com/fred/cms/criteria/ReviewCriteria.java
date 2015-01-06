/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:55:50 AM
 */
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
