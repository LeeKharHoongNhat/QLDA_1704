package com.ffse1704.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.query.Query;

public interface RepositoryDao<T, I extends Serializable> {
	
	I save(T instance);

	void update(T instance);

	void delete(T instance);

	T findById(I id);

	List<T> findByCriterion(Criterion criterion);

	Query<T> createQuery(String queryString);
}
