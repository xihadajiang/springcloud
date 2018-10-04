/**
 * <P> Copyright © 2011 Inspur Group Co.,Ltd.  版权所有 浪潮集团有限公司 </p>
 */
package com.inspur.incloud.log;

import com.inspur.incloud.common.UserSession;

/**
 * 系统日志service层的接口.
 *
 * @author liujunpeng
 */
public interface SyslogService {


    /**
     * 系统日志，事件级别为中.
     *
     * @param userSession
     *            ,包括userId,orgId,ip.
     * @param operResult
     *            操作结果。false:失败； true：成功
     * @param target
     *            目标
     * @param descriptionKey
     *            简要描述的在消息资源文件中的key。
     * @param descriptions
     *            简要描述中的变量数组。
     * @param details
     *            详细描述
     * @return 保存成功，返回true;失败返回false。
     */
    boolean addSysLog(UserSession userSession, boolean operResult,
            String target, String descriptionKey, Object[] descriptions,
            String details);

    /**
     * 系统日志.
     *
     * @param userSession
     *            ,包括userId,orgId,ip
     * @param eventLevel
     *            事件级别 高、中、低分别对应着2,1,0。
     * @param operResult
     *            操作结果。false:失败； true：成功
     * @param target
     *            目标
     * @param descriptionKey
     *            简要描述的在消息资源文件中的key。
     * @param descriptions
     *            简要描述中的变量数组。
     * @param details
     *            详细描述
     * @return 保存成功，返回true;失败返回false。
     */
    boolean addSysLog(UserSession userSession, int eventLevel,
            boolean operResult, String target, String descriptionKey,
            Object[] descriptions, String details);

    /**
     * 系统日志.
     *
     * @param userSession ,包括userId,orgId,ip
     * @param eventLevel 事件级别 高、中、低分别对应着2,1,0。
     * @param operResult 操作结果。false:失败； true：成功
     * @param target 目标
     * @param descriptionKey 简要描述的在消息资源文件中的key。
     * @param descriptions 简要描述中的变量数组。
     * @param details 详细描述
     * @param moduleType the module type
     * @return 保存成功，返回true;失败返回false。
     */
    boolean addSysLog(UserSession userSession, int eventLevel,
            boolean operResult, String target, String descriptionKey,
            Object[] descriptions, String details, ModuleType moduleType);

    /**
     * 操作日志，事件级别为中.
     *
     * @param userSession
     *            ,包括userId,orgId,ip.
     * @param operResult
     *            操作结果。false:失败； true：成功
     * @param target
     *            目标
     * @param descriptionKey
     *            简要描述的在消息资源文件中的key。
     * @param descriptions
     *            简要描述中的变量数组。
     * @param details
     *            详细描述
     * @return 保存成功，返回true;失败返回false。
     */
    boolean addOperlog(UserSession userSession, boolean operResult,
            String target, String descriptionKey, Object[] descriptions,
            String details);

    /**
     * 操作日志.
     *
     * @param userSession
     *            ,包括userId,orgId,ip
     * @param eventLevel
     *            事件级别 高、中、低分别对应着2,1,0。
     * @param operResult
     *            操作结果。false:失败； true：成功
     * @param target
     *            目标
     * @param descriptionKey
     *            简要描述的在消息资源文件中的key。
     * @param descriptions
     *            简要描述中的变量数组。
     * @param details
     *            详细描述
     * @return 保存成功，返回true;失败返回false。
     */
    boolean addOperlog(UserSession userSession, int eventLevel,
            boolean operResult, String target, String descriptionKey,
            Object[] descriptions, String details);

    /**
     * 操作日志.
     *
     * @param userSession ,包括userId,orgId,ip
     * @param eventLevel 事件级别 高、中、低分别对应着2,1,0。
     * @param operResult 操作结果。false:失败； true：成功
     * @param target 目标
     * @param descriptionKey 简要描述的在消息资源文件中的key。
     * @param descriptions 简要描述中的变量数组。
     * @param details 详细描述
     * @param moduleType the module type
     * @return 保存成功，返回true;失败返回false。
     */
    boolean addOperlog(UserSession userSession, int eventLevel,
            boolean operResult, String target, String descriptionKey,
            Object[] descriptions, String details, ModuleType moduleType);
    /**
     * 操作日志.
     *
     * @param userSession ,包括userId,orgId,ip
     * @param eventLevel 事件级别 高、中、低分别对应着2,1,0。
     * @param operResult 操作结果。false:失败； true：成功
     * @param target 目标
     * @param targetID the target id
     * @param targetOperType the target oper type
     * @param descriptionKey 简要描述的在消息资源文件中的key。
     * @param descriptions 简要描述中的变量数组。
     * @param details 详细描述
     * @param moduleType the module type
     * @return 保存成功，返回true;失败返回false。
     */
    boolean addOperlog(UserSession userSession, int eventLevel, boolean operResult, String target, String targetID,
            String targetOperType, String descriptionKey, Object[] descriptions, String details, ModuleType moduleType);

    /**
     * 操作日志.
     *
     * @param userSession ,包括userId,orgId,ip
     * @param eventLevel 事件级别 高、中、低分别对应着2,1,0。
     * @param operResult 操作结果。false:失败； true：成功
     * @param target 目标
     * @param targetID 目标 id
     * @param targetOperType 目标对象操作类型
     * @param descriptionKey 简要描述的在消息资源文件中的key。
     * @param descriptions 简要描述中的变量数组。
     * @param details 详细描述
     * @return 保存成功，返回true;失败返回false。
     */
    boolean addOperlog(UserSession userSession, int eventLevel, boolean operResult, String target,
            String targetID, String targetOperType, String descriptionKey,
            Object[] descriptions, String details);
    /**
     * 添加安全日志，事件级别为中.
     *
     * @param userSession
     *            ,包括userId,orgId,ip.
     * @param operResult
     *            操作结果。false:失败； true：成功
     * @param target
     *            目标
     * @param descriptionKey
     *            简要描述的在消息资源文件中的key。
     * @param descriptions
     *            简要描述中的变量数组。
     * @param details
     *            详细描述
     * @return 保存成功，返回true;失败返回false。
     */
    boolean addSecurityLog(UserSession userSession, boolean operResult,
            String target, String descriptionKey, Object[] descriptions,
            String details);

    /**
     * 添加安全日志.
     *
     * @param userSession
     *            ,包括userId,orgId,ip
     * @param eventLevel
     *            事件级别 高、中、低分别对应着2,1,0。
     * @param operResult
     *            操作结果。false:失败； true：成功
     * @param target
     *            目标
     * @param descriptionKey
     *            简要描述的在消息资源文件中的key。
     * @param descriptions
     *            简要描述中的变量数组。
     * @param details
     *            详细描述
     * @return 保存成功，返回true;失败返回false。
     */
    boolean addSecurityLog(UserSession userSession, int eventLevel,
            boolean operResult, String target, String descriptionKey,
            Object[] descriptions, String details);

    /**
     * 添加安全日志.
     *
     * @param userSession ,包括userId,orgId,ip
     * @param eventLevel 事件级别 高、中、低分别对应着2,1,0。
     * @param operResult 操作结果。false:失败； true：成功
     * @param target 目标
     * @param descriptionKey 简要描述的在消息资源文件中的key。
     * @param descriptions 简要描述中的变量数组。
     * @param details 详细描述
     * @param moduleType the module type
     * @return 保存成功，返回true;失败返回false。
     */
    boolean addSecurityLog(UserSession userSession, int eventLevel,
            boolean operResult, String target, String descriptionKey,
            Object[] descriptions, String details, ModuleType moduleType);
    
    /**
     * 记录服务实例的操作日志.
     *
     * @param userSession the user session
     * @param eventLevel 事件级别 高、中、低分别对应着2,1,0
     * @param operResult 操作结果。false:失败； true：成功
     * @param target 目标
     * @param targetID 目标 id
     * @param targetOwnerID 目标  owner id
     * @param targetOrgID 目标  org id
     * @param targetDomainID 目标  domain id
     * @param descriptionKey 简要描述的在消息资源文件中的key。
     * @param descriptions 简要描述中的变量数组。
     * @param details 详细描述
     * @param serviceCatalogID 所属服务目录ID
     * @return true, if successful
     */
    public boolean addServiceOperlog(UserSession userSession, int eventLevel, boolean operResult, String target,
            String targetID,String targetOwnerID, String targetOrgID, String targetDomainID, String descriptionKey, Object[] descriptions, String details,
            String serviceCatalogID);
}
