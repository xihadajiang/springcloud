package com.inspur.incloud.common.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.inspur.incloud.common.exception.CloudDBException;
import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;



/**
 * @author lvxianguo
 *
 * @param <T>
 * @param <PK>
 */
public interface BaseDao<T, PK extends Serializable> {

    /**
     * Gets the cur session.
     *
     * @return the cur session
     * @throws CloudDBException the cloud db exception
     */
    Session getCurSession() throws CloudDBException;

    /**
     * 同步对象.
     * @throws CloudDBException CloudDBException
     */
    void flush() throws CloudDBException;

    /**
     * Evict.
     *
     * @param object the object
     * @throws CloudDBException the cloud db exception
     */
    void evict(T object) throws CloudDBException;
    /**
     * @param object 要保存或者更新的对象
     * 保存或者更新对象
     * @throws CloudDBException CloudDBException
     */
    void saveOrUpdate(T object) throws CloudDBException;

    /**
     * @param object 要更新的对象
     * 更新对象
     * @throws CloudDBException CloudDBException
     */
    void update(T object) throws CloudDBException;

    /**
     * @param object
     * 保存对象接口
     * @return Serializable
     * @throws CloudDBException CloudDBException
     */
    Serializable save(T object) throws CloudDBException;

    /**
     * @param object
     * 删除对象接口
     * @throws CloudDBException CloudDBException
     */
    void delete(T object) throws CloudDBException;

    /**
     * @param entityClass 删除的对象类型
     * @param id 主键id
     * 根据主键id删除对象
     * @throws CloudDBException CloudDBException
     */
    void delete(Class<T> entityClass, final PK id) throws CloudDBException;
    /**
     * @param collection 删除的对象集合
     * 删除所有
     * @throws CloudDBException CloudDBException
     */
    void deleteAll(Collection<T> collection) throws CloudDBException;

    /**
     * @param hqlkey hql语句的key
     * @param values 参数
     * @return int 执行成功的条目
     * @throws CloudDBException CloudDBException
     */
    int batchExecute(final String hqlkey, final Object... values) throws CloudDBException;

    /**
     * @param hqlkey hql语句的key
     * @param values 参数
     * @return int 执行成功的条目
     * @throws CloudDBException CloudDBException
     */
    int batchExecute(final String hqlkey, final Map<String, ?> values) throws CloudDBException;

    /**
     * @param entityClass entityClass
     * @param id 主键id
     * @return 查询结构对象
     * @throws CloudDBException CloudDBException
     */
    T get(Class<T> entityClass, final PK id) throws CloudDBException;

    /**
     * @param hqlkey hql语句的key
     * @param values hql语句参数
     * @param <X> 泛型
     * @throws CloudDBException CloudDBException
     * @return 返回对象
     */
    <X> X findUnique(final String hqlkey, final Object... values) throws CloudDBException;
    /**
     * @param hqlkey hql语句的key
     * @param values hql语句参数
     * @param <X> 泛型
     * @throws CloudDBException CloudDBException
     * @return 返回对象
     */
    <X> X findUnique(final String hqlkey, final Map<String, ?> values) throws CloudDBException;
    /**
     * @param hqlkey hql语句的key
     * @param values hql语句参数
     * @param <X> 泛型
     * @throws CloudDBException CloudDBException
     * @return 返回对象列表
     */
    <X> List<X> find(final String hqlkey, final Object... values) throws CloudDBException;
    /**
     * @param hqlkey hql语句的key
     * @param values hql语句参数
     * @param <X> 泛型
     * @throws CloudDBException CloudDBException
     * @return 返回对象列表
     */
    <X> List<X> find(final String hqlkey, final Map<String, ?> values) throws CloudDBException;

    /**
     * @param hqlkey hql语句的key
     * @param values hql语句的参数
     * @return Query对象
     * @throws CloudDBException CloudDBException
     */
    Query createQuery(final String hqlkey, final Object... values) throws CloudDBException;
    /**
     * @param hqlkey hql语句的key
     * @param values hql语句的参数
     * @return Query对象
     * @throws CloudDBException CloudDBException
     */
    Query createQuery(final String hqlkey, final Map<String, ?> values) throws CloudDBException;
    /**
     * @param sqlSentence sql语句
     * @param values sql语句的参数
     * @param <X> 泛型
     * @throws CloudDBException CloudDBException
     * @return 查询对象
     */
    <X> X findUniqueBySqlSentence(final String sqlSentence, final Object... values) throws CloudDBException;
    /**
     * @param sqlSentence sql语句
     * @param values sql语句的参数
     * @param <X> 泛型
     * @throws CloudDBException CloudDBException
     * @return 查询对象
     */
    <X> X findUniqueBySqlSentence(final String sqlSentence, final Map<String, ?> values) throws CloudDBException;
    /**
     * @param sqlSentence sql语句
     * @param values sql语句的参数
     * @param <X> 泛型
     * @throws CloudDBException CloudDBException
     * @return 查询对象列表
     */
    <X> List<X> findBySqlSentence(final String sqlSentence, final Object... values) throws CloudDBException;
    /**
     * @param sqlSentence sql语句
     * @param values sql语句的参数
     * @param <X> 泛型
     * @throws CloudDBException CloudDBException
     * @return 查询对象列表
     */
    <X> List<X> findBySqlSentence(final String sqlSentence, final Map<String, ?> values) throws CloudDBException;
    /**
     * @param sql sql语句
     * @param values hql语句的参数
     * @return Query对象
     * @throws CloudDBException CloudDBException
     */
    Query createQuerySentence(final String sql, final Object... values) throws CloudDBException;
    /**
     * @param sql sql语句
     * @param values hql语句的参数
     * @return Query对象
     * @throws CloudDBException CloudDBException
     */
    Query createQuerySentence(final String sql, final Map<String, ?> values) throws CloudDBException;
    /**
     * @param sql sql语句
     * @param values hql语句的参数
     * @return SQLQuery对象
     * @throws CloudDBException CloudDBException
     */
    SQLQuery createSqlQuery(final String sql, final Object... values) throws CloudDBException;
    /**
     * @param sql sql语句
     * @param values hql语句的参数
     * @throws CloudDBException CloudDBException
     * @return SQLQuery对象
     */
    SQLQuery createSqlQuery(final String sql, final Map<String, ?> values) throws CloudDBException;
    /**
     * @param sql sql语句
     * @return SQLQuery对象
     * @throws CloudDBException CloudDBException
     */
    Query findBySql(final String sql) throws CloudDBException;
    /**
     * @param sql sql语句
     * @throws CloudDBException CloudDBException
     */
    void deleteByHql(final String sql) throws CloudDBException;
    /**
     * Delete by sql.
     *
     * @param sql the sql
     * @throws CloudDBException the cloud db exception
     */
    void deleteBySql(final String sql) throws CloudDBException;
    /**
     * @param sql sql语句
     * @param values hql语句的参数
     * @return int
     * @throws CloudDBException CloudDBException
     */
    int batchExecuteBySql(final String sql, final Object... values) throws CloudDBException;
    /**
     * @param sql sql语句
     * @param values hql语句的参数
     * @return int对象
     * @throws CloudDBException CloudDBException
     */
    int batchExecuteBySql(final String sql, final Map<String, ?> values) throws CloudDBException;

    /**
     * @param entityClass entityClass
     * @return List
     * @throws CloudDBException e
     */
    List<T> findAll(Class<T> entityClass) throws CloudDBException;

    /**
     * @param sql sql语句
     * @param values sql语句的参数
     * @param <X> 泛型
     * @throws CloudDBException CloudDBException
     * @return 查询对象列表
     */
    <X> X findOneByTemplate(String sql, final Object... values) throws CloudDBException;

    /**
     * @param sqlSentence sql语句
     * @param values sql语句的参数
     * @param <X> 泛型
     * @throws CloudDBException CloudDBException
     * @return 查询对象列表
     */
    <X> List<X> findListByTemplate(final String sqlSentence, final Object... values) throws CloudDBException;
    
    public PageListBean<T> getPageList(String sql, String countSql, List<Object> params, PageBean page)throws CloudDBException;
}
