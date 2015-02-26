package com.gdgcampinas.backend.dao.Generic;


import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static com.gdgcampinas.backend.util.OfyService.ofy;

public  class ObjectifyGenericDAO<T> implements IGenericDAO<T> {
    protected Class<T> clazz;

    @SuppressWarnings("unchecked")
    public ObjectifyGenericDAO() {
        clazz = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public Key<T> save(T entity) {
        return ofy().save().entity(entity).now();
    }

    @Override
    public void insert(T entity) {
        save(entity);
    }

    @Override
    public void delete(T entity) {
        ofy().delete().entity(entity).now();
    }

    @Override
    public void delete(Iterable<?> entities) {
        ofy().delete().entities(entities).now();
    }

    @Override
    public void update(T entity) {
        save(entity);
    }

    @Override
    public List<T> listAll() {
        Query<T> query = ofy().load().type(clazz);
        return query.list();
    }

    @Override
    public T getByProperty(String propName, Object propValue) {
        return ofy().load().type(clazz).filter(propName, propValue).first().now();
    }

    @Override
    public T getById(Long id) {
        return ofy().load().type(clazz).id(id).now();
    }

    @Override
    public List<T> listByProperty(String propName, Object propValue) {
        return ofy().load().type(clazz).filter(propName, propValue).list();
    }
}
