package com.inspur.incloud.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

public interface BaseDao<T> {

    public Session getCurrentSession();

    public Serializable save(T o);

    public void delete(T o);

    public void saveOrUpdate(T o);

    public void update(T o);

    public List<T> getByHQL(boolean withCache, String hql, Map<String, Object> params);

    public List<T> getByHQL(boolean withCache, String hql, Map<String, Object> params, int page, int rows);

    public long countByHQL(boolean withCache, String hql, Map<String, Object> params);

    public long countBySQL(boolean withCache, String sql, Map<String, Object> params);

    public List<Map<String,Object>> getResultMapBySql(String sql, Map<String, Object> params);

    public List<Map<String,Object>> getResultMapBySql(String sql, Map<String, Object> params, int page, int rows);

    public int executeHQL(String hql, Map<String, Object> params);

    public int executeSQL(String sql, Map<String, Object> params);

}
