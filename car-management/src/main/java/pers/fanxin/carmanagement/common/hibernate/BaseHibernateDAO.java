package pers.fanxin.carmanagement.common.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseHibernateDAO<T> implements BaseDAO<T> {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		return (T)getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		return getSessionFactory().getCurrentSession().save(entity);
	}

	@Override
	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	@Override
	public void update(T entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, Object... param) {
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i=0;i<param.length;i++){
			query.setParameter(i, param[i]);
		}
		return (List<T>)query.list();
	}

	@Override
	public List<T> findAll(Class<T> entityClazz) {
		return find("from "+entityClazz.getSimpleName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql) {
		return getSessionFactory().getCurrentSession().createQuery(hql).list();
	}

	@Override
	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from "+entityClazz.getSimpleName());
		if(l!=null&&l.size()==1){
			return (Long)l.get(0);
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql,int offset,int pageSize,Object... params){
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i=0;i<params.length;i++){
			query.setParameter(i, params[i]);
		}
		return query.setFirstResult(offset).setMaxResults(pageSize).list();
	}
	
}
