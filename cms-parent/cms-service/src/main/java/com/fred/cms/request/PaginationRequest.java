package com.fred.cms.request;

import java.io.Serializable;

public class PaginationRequest implements Serializable {

    private static final long serialVersionUID = -7415354446197805954L;

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
