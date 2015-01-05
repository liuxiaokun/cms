package com.fred.cms.dao.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T extends Serializable> {

    T getById(final int id);
    T getById(final String id);
    T getById(final long id);

    void deleteById(final int entityId);
    void deleteById(final String entityId);
    void deleteById(final long entityId);

    void update(final T entity);

    void delete(final T entity);

    void doFlush();

    void refreshObj(T entity);

    List<T> findAll();

    void save(final T entity);
}
