package com.cgi.crm.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgi.crm.dao.BaseDao;
import com.cgi.crm.util.Constants;

/**
 * 
 * @author skurapati
 *
 */
public class BaseDaoImpl implements BaseDao {
	private Logger LOG = Logger.getLogger(BaseDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	protected synchronized Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void saveOrUpdate(Object obj) {
		try {
			if (PropertyUtils.getProperty(obj, Constants.Common.COMMON_ID) != null) {
				getSession().merge(obj);
			} else {
				getSession().save(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
	}

	public Object getObjectById(Integer id, Class<?> clazz) {
		Object object = null;
		try {
			object = getSession().get(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return object;
	}

	public List<?> getListByQuery(String hqlQuery, Map<String, Object> queryParams, Integer firstResult,
			Integer maxResults) {
		List<?> list = null;
		try {
			if (hqlQuery != null) {
				Query query = getSession().createQuery(hqlQuery);
				if (queryParams != null && queryParams.size() > 0) {
					for (String name : queryParams.keySet()) {
						query.setParameter(name, queryParams.get(name));
					}
				}
				if (firstResult != null && maxResults != null) {
					query.setFirstResult(firstResult);
					query.setMaxResults(maxResults);
				}
				list = query.list();
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
		}
		return list;
	}
}
