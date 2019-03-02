package com.ffse1704.dao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

@Primary
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ResponsitoryDaoImpl<T, I extends Serializable> {

	private static final Log log = LogFactory.getLog(ResponsitoryDaoImpl.class);

	private Class<T> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	
	}

	public ResponsitoryDaoImpl() {	
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public I save(T instance) {
		log.debug("Saving " + persistentClass.getSimpleName() + " instance");
		try {
			I id = (I) sessionFactory.getCurrentSession().save(instance);
			log.debug("Save successful");
			return id;
		} catch (RuntimeException re) {
			throw new RuntimeException();
		}
	}

	public void update(T instance) {
		log.debug("Updating " + persistentClass.getSimpleName() + " instance");
		try {
			sessionFactory.getCurrentSession().update(instance);
			log.debug("Update successful");
		} catch (RuntimeException re) {
			throw new RuntimeException();
		}
	}

	public void delete(T instance) {
		log.debug("Deleting " + persistentClass.getSimpleName() + " instance");
		try {
			sessionFactory.getCurrentSession().delete(instance);
			log.debug("Delete successful");
		} catch (RuntimeException re) {
			throw new RuntimeException();
		}
	}

	public T findById(I id) {
		log.debug("Getting " + persistentClass.getSimpleName() + " instance with id: " + id);
		try {
			T instance = (T) sessionFactory.getCurrentSession().get(persistentClass.getName(), id);
			if (instance == null) {
				log.debug("Get successful, no instance found");
			} else {
				log.debug("Get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			throw new RuntimeException();
		}
	}

	public List<T> findByCriterion(Criterion criterion) {
		log.debug("Finding " + persistentClass.getSimpleName() + " instance by criterion");
		try {
			@SuppressWarnings("deprecation")
			List results = sessionFactory.getCurrentSession().createCriteria(persistentClass.getName()).add(criterion)
					.list();
			log.debug("Find by criterion successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			throw new RuntimeException();
		}
	}

	public Query<T> createQuery(String queryString) {
		log.debug("Creating " + persistentClass.getSimpleName() + " query");
		try {
			Query<T> sqlQuery = sessionFactory.getCurrentSession().createQuery(queryString, persistentClass);
			log.debug("Create query successful");
			return sqlQuery;
		} catch (RuntimeException re) {
			throw new RuntimeException();
		}
	}

}
