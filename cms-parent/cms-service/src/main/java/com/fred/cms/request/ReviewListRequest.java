/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:58:21 AM
 */
package com.fred.cms.request;

public class ReviewListRequest extends PaginationRequest {

    private static final long serialVersionUID = 4419771638459093878L;

    private Integer contentId;

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

}
