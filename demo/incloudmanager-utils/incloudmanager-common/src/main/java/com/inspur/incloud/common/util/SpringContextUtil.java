/**
 * <P>
 * Copyright © 2011 Inspur Group Co.,Ltd. 版权所有 浪潮集团有限公司
 * </p>
 **/
package com.inspur.incloud.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * The Class AsynSpringUtil.
 */
public class SpringContextUtil {

    /** The application context. */
    private static ApplicationContext applicationContext;

    /**
     * get spring bean with beanName.
     * @param applicationContext the new application context
     * @throws BeansException the beans exception
     */
    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    	SpringContextUtil.applicationContext = applicationContext;

    }

    /**
     * get spring bean with beanName.
     * @param beanName the bean name
     * @return the bean
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
    
    public static <T> Object getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    /**
     * * 类似于getBean(String name)只是在参数中提供了需要返回到的类型。.
     * @param name the name
     * @param requiredType the required type
     * @return the bean
     * @throws BeansException the beans exception
     */
    public static Object getBean(String name, Class requiredType) throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true.
     * @param name the name
     * @return boolean
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）.
     * @param name the name
     * @return boolean
     * @throws NoSuchBeanDefinitionException the no such bean definition
     *             exception
     */
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(name);
    }

    /**
     * Gets the type.
     * @param name the name
     * @return Class 注册对象的类型
     * @throws NoSuchBeanDefinitionException the no such bean definition
     *             exception
     */
    public static Class getType(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名.
     * @param name the name
     * @return the aliases
     * @throws NoSuchBeanDefinitionException the no such bean definition
     *             exception
     */
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getAliases(name);
    }

}
