/**
 * @author Fred Liu <liuxiaokun0410@qq.com>
 * @version 1.7
 * @since Jan 6, 2015 8:56:22 AM
 */
package com.fred.cms.dao.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDaoImpl<T extends Serializable> implements BaseDao<T> {

    @PersistenceContext(unitName = "fred")
    protected EntityManager entityManager;

    @PersistenceContext(unitName = "fred")
    protected EntityManager readEntityManager;

    protected Class<T> clazz;

    public final void setClazz(final Class<T> clazz) {
        this.clazz = clazz;
    }

    public final EntityManager getEM(final Boolean isReadOnly) {
        return isReadOnly ? this.readEntityManager : this.entityManager;
    }

    @Override
    public final T getById(final int id) {
        return getEM(false).find(clazz, id);
    }

    @Override
    public final T getById(final String id) {
        return getEM(false).find(clazz, id);
    }

    @Override
    public final T getById(final long id) {
        return getEM(false).find(clazz, id);
    }

    @Override
    public final void update(final T entity) {
        entityManager.merge(entity);
    }

    @Override
    public final void delete(final T entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public final void deleteById(final int entityId) {
        final T entity = getById(entityId);
        delete(entity);
    }

    @Override
    public final void deleteById(final String entityId) {
        final T entity = getById(entityId);
        delete(entity);
    }

    @Override
    public final void deleteById(final long entityId) {
        final T entity = getById(entityId);
        delete(entity);
    }

    @Override
    public final void doFlush() {
        entityManager.flush();
    }

    @Override
    @SuppressWarnings("unchecked")
    public final List<T> findAll() {
        return getEM(false).createQuery("from " + clazz.getName()).getResultList();
    }

    @Override
    public final void save(final T entity) {
        entityManager.persist(entity);
    }

    @Override
    public final void refreshObj(final T entity) {
        entityManager.refresh(entity);
    }
}
