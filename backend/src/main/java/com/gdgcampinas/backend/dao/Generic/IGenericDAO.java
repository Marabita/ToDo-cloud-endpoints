package com.gdgcampinas.backend.dao.Generic;

import com.googlecode.objectify.Key;

import java.util.List;

public interface IGenericDAO<T> {

    Key<T> save(T entity);

    void insert(T entity);

    void delete(T entity);

    void delete(Iterable<?> entities);

    void update(T entity);

    List<T> listAll();

    T getByProperty(String propName, Object propValue);

    T getById(Long id);

    List<T> listByProperty(String propName, Object propValue);
}
