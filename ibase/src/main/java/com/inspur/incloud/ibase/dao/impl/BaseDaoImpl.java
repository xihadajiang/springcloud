package com.inspur.incloud.ibase.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inspur.incloud.ibase.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

   @Autowired
   private SessionFactory sessionFactory;

   public Session getCurrentSession() {
      return sessionFactory.openSession();
   }

   public Serializable save(T o) {
      return getCurrentSession().save(o);
   }
   public void delete(T o) {
      getCurrentSession().delete(o);
   }
   public void saveOrUpdate(T o) {
      getCurrentSession().saveOrUpdate(getCurrentSession().merge(o));
   }

   public void update(T o) {
      getCurrentSession().update(o);
   }

   public List<T> getByHQL(boolean withCache, String hql, Map<String, Object> params) {
      Query q = getCurrentSession().createQuery(hql);
      if (params != null && !params.isEmpty()) {
         for (String key : params.keySet()) {
            q.setParameter(key, params.get(key));
         }
      }
      return q.setCacheable(withCache).list();
   }

   public List<T> getByHQL(boolean withCache, String hql, Map<String, Object> params, int page, int rows) {
      Query q = getCurrentSession().createQuery(hql);
      if (params != null && !params.isEmpty()) {
         for (String key : params.keySet()) {
            q.setParameter(key, params.get(key));
         }
      }
      return q.setCacheable(withCache).setFirstResult((page - 1) * rows)//
            .setMaxResults(rows)//
            .list();
   }

   public long countByHQL(boolean withCache, String hql, Map<String, Object> params) {
      Query q = getCurrentSession().createQuery(hql);
      if (params != null && !params.isEmpty()) {
         for (String key : params.keySet()) {
            q.setParameter(key, params.get(key));
         }
      }
      return (Long) q.setCacheable(withCache).uniqueResult();
   }

   public long countBySQL(boolean withCache, String sql, Map<String, Object> params) {
      SQLQuery q = getCurrentSession().createSQLQuery(sql);
      if (params != null && !params.isEmpty()) {
         for (String key : params.keySet()) {
            q.setParameter(key, params.get(key));
         }
      }
      return (Long) q.setCacheable(withCache).uniqueResult();
   }

   public List<Map<String, Object>> getResultMapBySql(String sql, Map<String, Object> params) {
      SQLQuery q = getCurrentSession().createSQLQuery(sql);
      if (params != null && !params.isEmpty()) {
         for (String key : params.keySet()) {
            q.setParameter(key, params.get(key));
         }
      }
      return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
   }

   public List<Map<String, Object>> getResultMapBySql(String sql, Map<String, Object> params, int page, int rows) {
      SQLQuery q = getCurrentSession().createSQLQuery(sql);
      if (params != null && !params.isEmpty()) {
         for (String key : params.keySet()) {
            q.setParameter(key, params.get(key));
         }
      }
      return q.setFirstResult((page - 1) * rows)//
            .setMaxResults(rows)//
            .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)//
            .list();
   }

   public int executeHQL(String hql,Map<String,Object> params) {
      Query q = getCurrentSession().createQuery(hql);
      if (params != null && !params.isEmpty()) {
         for (String key : params.keySet()) {
            q.setParameter(key, params.get(key));
         }
      }
      return q.executeUpdate();
   }

   public int executeSQL(String sql,Map<String,Object> params) {
      SQLQuery q = getCurrentSession().createSQLQuery(sql);
      if (params != null && !params.isEmpty()) {
         for (String key : params.keySet()) {
            q.setParameter(key, params.get(key));
         }
      }
      return q.executeUpdate();
   }


}
