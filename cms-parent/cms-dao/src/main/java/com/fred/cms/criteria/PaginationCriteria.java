package com.fred.cms.criteria;

import java.io.Serializable;

public class PaginationCriteria implements Serializable {

    private static final long serialVersionUID = 6574830534432403138L;

    private Integer offset;

    private Integer limit;

    public final Integer getOffset() {
        return offset;
    }

    public final void setOffset(final Integer offset) {
        this.offset = offset;
    }

    public final Integer getLimit() {
        return limit;
    }

    public final void setLimit(final Integer limit) {
        this.limit = limit;
    }

}