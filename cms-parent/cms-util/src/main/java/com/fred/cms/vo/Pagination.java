/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 9:00:28 AM
 */
package com.fred.cms.vo;

import java.io.Serializable;
import java.util.List;

public final class Pagination<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -4575642733370223572L;

    private List<T> list;

    private int count;

    public Pagination() {
    }

    public Pagination(final List<T> list, final int count) {
        this.list = list;
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(final List<T> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

}
