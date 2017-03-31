package com.cgi.crm.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao {
	public void saveOrUpdate(Object obj);

	public Object getObjectById(Integer id, Class<?> clazz);

	public List<?> getListByQuery(String hqlQuery, Map<String, Object> queryParams, Integer firstResult,
			Integer maxResults);
}
